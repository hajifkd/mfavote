#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
# send.py
# created by H.Fukuda

from email.MIMEText import MIMEText
from email.Header import Header
from email.Utils import *
from email import message_from_file

import re
import os
import urllib
import urllib2
import simplejson
from datetime import datetime

import sys, codecs
sys.stdout = codecs.getwriter('utf-8')(sys.stdout)
sys.stderr = codecs.getwriter('utf-8')(sys.stderr)

FROM_NAME = u"五月祭常任委員会"
FROM_ADDR = "mfjc@a103.net"
MATCH_CASE = re.compile(r'mfjc\-mfa\-([0-9]{3})@a103\.net')

def create_message(to_addr, subject, body, encoding='ISO-2022-JP'):
    body += u"\n\n※現在駒ぷりシステム試験中です。この投票は集計されません。"
    msg = MIMEText(body.encode(encoding, 'replace'), 'plain', encoding);
    msg['Subject'] = Header(subject, encoding)
    msg['From'] = '%s <%s>' % (str(Header(FROM_NAME, encoding)), FROM_ADDR)
    msg['To'] = to_addr
    msg['Date'] = formatdate(localtime=True)
    return msg

def send_message(to_addr, msg):
    p = os.popen("/usr/sbin/sendmail -t", "w")
    p.write(msg.as_string())
    p.close()

def make_url(query):
    return "http://localhost/may/85/system/mfa/get_code?" + urllib.urlencode(query)

def get_result(url):
    try:
        res = simplejson.load(urllib2.urlopen(url))
    except Exception as e:
        res = {'success' : False, 'msg' : u'不正なリクエストです'}

    return res

def main():

    msg = message_from_file(sys.stdin)
    print >>sys.stderr, '\n[[%s]]' % formatdate(localtime=True)
    print >>sys.stderr, msg.as_string()

    m = MATCH_CASE.match(parseaddr(msg['To'])[1])
    kikaku_id = int(m.groups()[0])
    res = get_result(make_url([('address', "hogehoge@fugafuga.com"), ('id', 301)]))
    voter = parseaddr(msg['From'])[1]

    if res['success']:
        body = u'''ご投票ありがとうございます。
あなたが投票された企画は、「%s」の「%s」となります。

現在%d票投票しています。一人3票投票できますので、ふるってご投票下さい。
また、赤門、正門、農学部の各投票所で福引に参加できます。コードは

%s

となります。こちらを各投票所で打ち込んで下さい。''' % (res['kikaku_name'], res['org_name'], res['num'], res['code'])

    else:
        body = u'''申し訳ありません。%s''' % success['msg']

    print body

if __name__ == "__main__":
    try:
        main()
    except Exception as e:
        print >>sys.stderr ,str(e)

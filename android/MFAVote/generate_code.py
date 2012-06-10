#!/usr/bin/env python

import random

data = random.randint(0, 10E6 - 1)

parity4 = (data % 13) % 10
parity1 = (data % 29) % 10
parity0 = (data % 101) % 10

code = ''

for i in range(7):
    if i in (0, 1, 4):
        code = str(globals()['parity%d' % i]) + code
    bit = data % 10
    data /= 10
    code = str(bit) + code

print code

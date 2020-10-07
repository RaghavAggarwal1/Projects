
import sys
import gzip
with open ("juliaplaintext.txt.gz.enc","rb") as f:
    data = f.read()

key = "wkFKHQdJQWRK" * 5000

s = open("juliaplaintext.txt.gz", "wb")

for ch0,ch1 in zip(data,key):
    db = chr(ch0^ord(ch1))
    rotated = (ord(db)>>4 | ord(db) << 4 & 0xff)
    s.write(bytes([rotated]))
s.close()





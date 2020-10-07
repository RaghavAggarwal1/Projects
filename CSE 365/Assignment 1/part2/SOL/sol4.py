
import sys
import gzip
with open ("secretfile.txt.gz.enc","rb") as f:
    data = f.read()

key = "nYdzdQovCrsH" * 5000
       

s = open("secretfile.txt.gz", "wb")

for ch0,ch1 in zip(data,key):
    db = chr(ch0^ord(ch1))
    rotated = (ord(db)>>3 | (ord(db) << 5) & 0xff)
    s.write(bytes([rotated]))
s.close()





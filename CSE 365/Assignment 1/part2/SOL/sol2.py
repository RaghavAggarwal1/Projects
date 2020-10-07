with open ("ciphertext.txt","r") as f:
    data= f.read()
s = open("caesarplaintext.txt", "w")
for ch in data:
    rotated = chr(ord('A')+ (ord(ch) - (ord('A')+18))%26)
    s.write(rotated)
s.close()
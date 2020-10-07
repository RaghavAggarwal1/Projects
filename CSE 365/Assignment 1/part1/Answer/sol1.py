with open ("ciphertext.txt","r") as f:
    data= f.read()
s = open("ciphertext1.txt", "w")
for ch in data:
    rotated = chr(ord('A')+ (ord(ch) - (ord('A')+25))%26)
    s.write(rotated)
s.close()
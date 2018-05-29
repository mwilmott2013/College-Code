import subprocess

d = input("Enter username: ")

e = input("Enter Generating Program: ")

a = input("Enter GP Matrix Size: ")

f = input("Enter Oracle: ")

p = subprocess.Popen(["ssh", d+"@andrew.cs.fit.edu", "/home/fit.edu/kgallagher/public_html/sampleprogs/" +e, a], stdout=subprocess.PIPE, stdin=subprocess.PIPE, stderr=subprocess.PIPE)
outOne, errOne = p.communicate()
p.kill()
print(outOne.decode('utf-8'))

q = subprocess.Popen(["/usr/bin/java", "Assignment1AResubmit"], stdout=subprocess.PIPE, stdin=subprocess.PIPE, stderr=subprocess.PIPE)
outTwo, errTwo = q.communicate(outOne)
q.kill()
print(outTwo.decode('utf-8'))

r = subprocess.Popen(["ssh", d+"@andrew.cs.fit.edu", "/home/fit.edu/kgallagher/public_html/oracles/" +f], stdout=subprocess.PIPE, stdin=subprocess.PIPE, stderr=subprocess.PIPE)
outThree, errThree = r.communicate(outOne)
r.kill()
print(outThree.decode('utf-8'))
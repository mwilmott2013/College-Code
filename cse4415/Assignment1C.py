import subprocess
import time

e = input("Enter Generating Program: ")

a = input("Enter GP Matrix Size: ")

p = subprocess.Popen(["ssh", "mwilmott2013@andrew.cs.fit.edu", "/home/fit.edu/kgallagher/public_html/sampleprogs/" +e, a], stdout=subprocess.PIPE, stdin=subprocess.PIPE, stderr=subprocess.PIPE)
outOne, errOne = p.communicate()
p.kill()
print(outOne.decode('utf-8'))

oneStartTime = time.time()
q = subprocess.Popen(["/usr/bin/java", "Assignment1AResubmit"], stdout=subprocess.PIPE, stdin=subprocess.PIPE, stderr=subprocess.PIPE)
outTwo, errTwo = q.communicate(outOne)
q.kill()
print(outTwo.decode('utf-8'))
print("--- %s seconds ---" % (time.time() - oneStartTime))

twoStartTime = time.time()
r = subprocess.Popen(["ssh", "mwilmott2013@andrew.cs.fit.edu", "/home/fit.edu/kgallagher/public_html/oracles/" +e], stdout=subprocess.PIPE, stdin=subprocess.PIPE, stderr=subprocess.PIPE)
outThree, errThree = r.communicate(outOne)
r.kill()
print(outThree.decode('utf-8'))
print("--- %s seconds ---" % (time.time() - twoStartTime))
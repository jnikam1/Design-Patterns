======================================= Design Pattern ===============================================
--------------------------------------- Assignment 01 ------------------------------------------------ 
Team Members:

Name: Bhawesh Sehgal
BUID:

Name: Jayesh Nikam
BUID: B00850264

Description:
The idea is to create a Template Method Pattern parent class and just work on the two methods boolean checkGenEds() and abstract boolean checkForeignLang()

The Gened representation is { A, B, C, FL1, FL2, FL3, G, H, J, L, M, N, O, P, S, W, Y  }

The Foreign language is actually checked separately, every student must have one each from A, C, G, H, L, M, N, O, P, S, Y, and satisfy Foreign Language.
If you take a J course, you automatically get both C and O.
If you take a B course, you automatically get both S and Y.

If a course has a C, O, or J, it can double count with one of the other Gened's if the course carries other Gened's.
If the course has more than one of the A, G, H, L, M, N, P, S, Y, (B = S & Y), only one can be used to meet the student's Gened requirement--the choice of which one is optimized automatically to get as many Gened's out of the combination of courses taken.
Foreign language: If the student is in CS or Nursing, they only need to take one FL1, FL2, or FL3 course. Engineering students do not need any FL course. All other students have to take FL1, FL2, FL3 in one language, or have to take FL1 and FL2 in 2 separate languages. 
High School courses, Advanced Placement credit, and International Baccalaureate credit can be used for many requirements but do not program that part.


Output:
FullFLAudit
TEST 1
Has FL3: Spanish
still need O or J course
Geneds NOT complete
-------------------------
OneFLAudit
TEST 1
Has FL: Arabic
still need O or J course
Geneds NOT complete
--------------------------
ZeroFLAudit
TEST 1
still need O or J course
Geneds NOT complete


Execution steps:
Successfully tested following test cases provided by professor.
TesterFullAudit.java
TesterOneFLAudit.java
TesterZeroFLAudit.java
# Lab Report, Code Quality and Design Quality

Repository URL: https://github.com/Getto55/itcs382-lab.git

## Tools

| Item | Version or name |
| --- | --- |
| JDK | 25.0.4.1 |
| Maven | 3.10.0 |
| IDE | 0.31.2 |
| SonarQube for IDE | 6.2.0 |
| AI tool and exact model | Gemini 3.1 Pro |

## Task 1. SonarQube on the starter code

Commit of the starter, before any change: afe4e3f

Table 1. SonarQube issues in the starter code

| No. | Rule | File:line | Message |
| --- | --- | --- | --- |
| 1 | Standard outputs should not be used directly to log anything (java:S106) | Main.java: [Ln 9, Col 9] | Replace this use of System.out by a logger. |
| 2 | Standard outputs should not be used directly to log anything (java:S106) | Main.java: [Ln 15, Col 17] | Replace this use of System.out by a logger. |
| 3 | Standard outputs should not be used directly to log anything (java:S106) | Main.java: [Ln 17, Col 17] | Replace this use of System.out by a logger. |
| 4 | Standard outputs should not be used directly to log anything (java:S106) | Main.java: [Ln 22, Col 17] | Replace this use of System.out by a logger. |
| 5 | "java.time" classes should be used for dates and times (java:S2143) | ParcelService.java: [Ln 1, Col 1] | Use the "java.time" API for date and time. |
| 6 | Unnecessary imports should be removed (java:S1128) | ParcelService.java: [Ln 6, Col 8] | Remove this unused import 'java.util.Date'. |
| 7 | Unnecessary imports should be removed (java:S1128) | ParcelService.java: [Ln 12, Col 17] | Remove this unused "maxParcels" private field. |
| 8 | Standard outputs should not be used directly to log anything (java:S106) | ParcelService.java: [Ln 30, Col 17] | Replace this use of System.out by a logger. |
| 9 | Strings and Boxed types should be compared using "equals()" (java:S4973) | ParcelService.java: [Ln 42, Col 52] | Strings and Boxed types should be compared using "equals()". |
| 10 | Standard outputs should not be used directly to log anything (java:S106) | ParcelService.java: [Ln 67, Col 17] | Replace this use of System.out by a logger. |
| 11 | Standard outputs should not be used directly to log anything (java:S106) | ParcelService.java: [Ln 69, Col 17] | Replace this use of System.out by a logger. |
| 12 | Resources should be closed (java:S2095) | ParcelService.java: [Ln 76, Col 33] | Use try-with-resources or close this "FileWriter" in a "finally" clause. |
| 13 | Nested blocks of code should not be left empty (java:S108) | ParcelService.java: [Ln 80, Col 33] | Remove this block of code, fill it in, or add a comment explaining why it is empty. |

## Task 2. AI review of the starter code

| Item | Value |
| --- | --- |
| Date | 25/10/2026 |
| AI tool and exact model | Gemini 3.1 Pro |
| Commit reviewed | afe4e3f |
| How the AI read the files (attached the files, opened the folder, or pasted the files) | attached the files |
| Output file in the reviews folder | C:\Users\Lenovo\Documents\Get\Software Modeling\Lab\itcs382-lab\reviews\parcelpoint-review.md |

Table 2. All findings on the starter code

| No. | File:line | Finding | Found by (SonarQube, AI or both) | SonarQube rule or course term | Correct? (yes or no, and why) |
| --- | --- | --- | --- | --- | --- |
| 1 | ParcelService.java: [Ln 42, Col 51] | compares string objects using == instead of .equals() | Both | trings and Boxed types should be compared using "equals()" (java:S4973) | Yes, to compare two string you need to use .equal() instead of == |
| 2 | ParcelService.java: [Ln 76, Col 32] | FileWriter resource is never closed | Both | Resources should be closed (java:S2095) | Yes, FileWriter need to be closed. |
| 3 | ParcelService.java: [Ln 80, Col 32] | Empty block | Both | Nested blocks of code should not be left empty (java:S108) | Yes, if the box left empty, an error can be hidden. |
| 4 | ParcelService.java: [Ln 66, Col 7] | Unused import | Both | Unnecessary imports should be removed (java:S1128) | Yes, to improve the readability and maintainability of the code. |
| 5 | ParcelService: [Ln 12, Col 16] | Unused private field | Both | Unused "private" fields should be removed (java:S1068) | Yes, its limited visibility makes it dead code. |
| 6 | ParcelService: [Ln 1, Col 0] | Use the "java.time" instead | SonarQube | "java.time" classes should be used for dates and times (java:S2143) | Yes, the built-in java.time (JSR-310) API provides a modern, immutable, and thread-safe framework |
| 7 | Main.java: [Ln 9, Col 8] | Replace system.out with logger | SonarQube | Standard outputs should not be used directly to log anything (java:S106) | Yes, logger securely logged when dealing with sensitive data |
| 8 | Main.java: [Ln 15, Col 16] | Replace system.out with logger | SonarQube | Standard outputs should not be used directly to log anything (java:S106) | Yes, logger securely logged when dealing with sensitive data |
| 9 | Main.java: [Ln 17, Col 16] | Replace system.out with logger | SonarQube | Standard outputs should not be used directly to log anything (java:S106) | Yes, logger securely logged when dealing with sensitive data |
| 10 | Main.java: [Ln 22, Col 16] | Replace system.out with logger | SonarQube | Standard outputs should not be used directly to log anything (java:S106) | Yes, logger securely logged when dealing with sensitive data |
| 11 | ParcelService: [Ln 30, Col 16] | Replace system.out with logger | SonarQube | Standard outputs should not be used directly to log anything (java:S106) | Yes, logger securely logged when dealing with sensitive data |
| 12 | ParcelService: [Ln 67, Col 16] | Replace system.out with logger | SonarQube | Standard outputs should not be used directly to log anything (java:S106) | Yes, logger securely logged when dealing with sensitive data |
| 13 | ParcelService: [Ln 69, Col 16] | Replace system.out with logger | SonarQube | Standard outputs should not be used directly to log anything (java:S106) | Yes, logger securely logged when dealing with sensitive data |
| 14 | ParcelService.java: Ln 7 | ParcelService shows weak class cohesion | AI only | - | Yes, divide into smaller class make a clear responsibility |
| 15 | ParcelService.java: Ln 22 | storeParcel has procedural cohesion | AI only | - | Yes, it contain many action that weakly connected to each other. |
| 16 | ParcelService.java: Ln 64 | printParcels has logical cohesion | AI only | - | Yes, The method does two different jobs depending on the flag. |
| 17 | ParcelService.java: Ln 64 | Passing boolean forStaff creates control coupling between Main and ParcelService. | AI only | - | Yes, It ties the caller to the method’s internal logic. |
| 18 | Main.java: Ln 22 | Strong coupling on Main.java | AI only | - | Yes, If the service changes how it stores lockers, Main breaks. |
| 19 | Locker.java: Ln 5 | Connascence of convention exists between Locker and Parcel. | AI only | - | Yes, The meaning of each number exists only by agreement between developers.  |
| 20 | Parcel.java: Ln 6 | The status field is public, breaking encapsulation. | AI only | - | Yes, Any class can set status to any value without checks making cannot control its own state. |
| 21 | ParcelService.java: Ln 18 | getLockers() returns the internal collection directly, allowing callers to maliciously or accidentally modify the list | AI only | - | Yes, Callers can add or remove lockers and skip the service’s rules. |

2.1 Name two problems that only the AI review found <br>- ParcelService shows weak class cohesion <br>- storeParcel has procedural cohesion

2.2 Name one problem that only SonarQube found, or write none. 
<br>- Replace system.out with logger

2.3 Name one AI finding that was wrong or too vague, and explain why. If every finding was right, explain how you checked them.
<br>- ParcelService shows weak class cohesion, It is too vague because this class doesn't say that it responsible for all the method it contain.

## Task 3. Fix and check

Table 3. What you did with each SonarQube issue in Table 1

| No. in Table 1 | Fixed or kept | Commit, or the reason for keeping it |
| --- | --- | --- |
| 1 | Kept | system.out is for user output, not for logging |
| 2 | Kept system.out is for user output, not for logging|  |
| 3 | Kept | system.out is for user output, not for logging |
| 4 | Kept | system.out is for user output, not for logging |
| 5 | Fixed | replace the java.util.Date usage with java.time |
| 6 | Fixed | delete import java.util.Date; |
| 7 | Fixed | delete the unused maxParcels field |
| 8 | Kept | system.out is for user output, not for logging |
| 9 | Fixed | replace == with .equals() |
| 10 | Kept | system.out is for user output, not for logging |
| 11 | Kept | system.out is for user output, not for logging |
| 12 | Fixed | Close FileWriter with try-with-resources |
| 13 | Fixed | Handle exception |

Number of SonarQube issues that remain after your fixes: 10

The two design problems that you fixed

| Design problem (course term) | What you changed | Commit |
| --- | --- | --- |
| Use try-with-resources or close this "FileWriter" in a "finally" clause. | put the FileWriter in a try-with-resources block | f449b2b |
| Nested blocks of code should not be left empty | add catch exception | 1341211 |

Output of the program after your fixes, for the commands `store P1 6501 2`, `pickup P1 5` and `staff`, and the content of parcels.csv:

```text
store P1 6501 2
SMS to 6501: parcel P1 is in locker 2
Locker 2
pickup P1 5
Fee: 0.0
staff
P1 6501 STORED
Free lockers: 2

output: P1,STORED
```

## Task 4. AI-generated poor and good designs

| Item | bikeshare-poor | bikeshare-good |
| --- | --- | --- |
| Date | 25/10/2026 | 25/10/2026 |
| AI tool and exact model | Gemini 3.1 Pro | Gemini 3.1 Pro |
| Prompt (B or C as given, or your changed prompt in full) | C | B |
| Builds with mvn package (yes or no) |Yes | Yes|
| Number of classes, interfaces, enums and records | 1 | 10 |
| SonarQube issues, total | 22|39 |
| SonarQube issues, by rule | | |
| AI review findings in Check 1 | | |
| AI review findings in Check 2 | | |
| Review output file in the reviews folder | | |

4.1 Did SonarQube report any cohesion or coupling problem in bikeshare-poor? Quote the rule and the message if it did.

4.2 Did the AI review tell the two versions apart? Give one finding for bikeshare-poor that does not appear for bikeshare-good.

4.3 Which version would you rather extend with a new member type, such as a visitor who pays 4 baht per minute, and why?

## Task 5. Reflection

5.1 What does SonarQube check, and what does it not check? Answer with examples from this lab.

5.2 When should you not trust the AI review? Give an example from this lab.

5.3 What will you do differently in Project Phase 2 after this lab?

## AI usage declaration

| AI tool and exact model | Purpose | Files or parts that it produced or changed | How you checked its output |
| --- | --- | --- | --- |
| | | | |

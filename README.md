# Java Mini Projects

This repository contains four Java mini projects built using core Java concepts such as OOP, file handling, collections, and console-based UI. Each project demonstrates practical problem-solving and clean program structure.

---

## 📌 Projects Included

### 1. Expense Tracker (File Based)
A console application to manage daily expenses with persistent storage.

**Features**
- Add and view expenses  
- Monthly summaries  
- Category-based tracking  
- Stores all records in `expenses.txt`  
- Implemented using BufferedReader and BufferedWriter  

---

### 2. Portfolio Website Generator (Java → HTML)
A Java program that generates a complete HTML portfolio website from user inputs.

**Features**
- Accepts name, about, skills, projects, and contact info  
- Creates `portfolio.html` with embedded CSS styling  
- Uses Java FileWriter & BufferedWriter  
- Automatically opens in browser using Desktop API  

---

### 3. Quiz Game (Multi-Level + OOP)
A structured quiz game built using Object-Oriented Programming and levels-based progression.

**Game Rules**
- Total **5 levels**  
- Each level has **3 multiple-choice questions**  
- Player must score **at least 2 out of 3** to unlock the next level  
- Game ends when the player fails a level  
- Shows final score and progress  

**Features**
- Question class for managing question text and answers  
- Level-based difficulty progression  
- Score tracking  
- Clean and interactive console flow  

---

### 4. To-Do List (Task Manager)
A simple task management tool with persistent storage.

**Features**
- Add tasks  
- View tasks  
- Mark tasks as completed  
- Delete tasks  
- Saves tasks in a file for future use  

---

## ▶️ How to Run Any Project

Compile:
```bash
javac -d out src/**/*.java

# Java Basics Homework 18 — Employee and Manager Classes

## Overview

Create a Java program made of three files: an `Employee` class, a `Manager` class that **extends** `Employee`, and a driver class that reads values from the user. This assignment covers polymorphism — using a superclass-typed variable to hold a subclass object, so the correct overridden method runs automatically based on the object's actual type.

**Files:** `Employee.java`, `Manager.java`, `EmployeeDemo.java`

---

## Requirements

### `Employee.java`

- Two private instance fields:
  ```java
  private String name;
  private double baseSalary;
  ```
- A constructor:
  ```java
  public Employee(String name, double baseSalary)
  ```
- A method that returns pay:
  ```java
  public double calculatePay() {
      return baseSalary;
  }
  ```
- Getters for both fields.

### `Manager.java`

- `Manager` must **extend** `Employee`:
  ```java
  public class Manager extends Employee
  ```
- One additional private field:
  ```java
  private double bonus;
  ```
- A constructor that calls the `Employee` constructor with `super(...)`, then sets `bonus`.
- An **overridden** version of `calculatePay()` that calls `super.calculatePay()` and adds the bonus:
  ```java
  @Override
  public double calculatePay() {
      return super.calculatePay() + bonus;
  }
  ```
- A getter for `bonus`.

### `EmployeeDemo.java`

- Contains `public static void main(String[] args)`.
- Uses `Scanner` to read all values — nothing should be hard-coded:
  1. Ask whether this employee is a manager (`yes`/`no`).
  2. Prompt for the employee's name and base salary.
  3. If the answer was `yes`, also prompt for a bonus amount.
- Declare a single variable of type `Employee`, and assign it either a `new Employee(...)` or a `new Manager(...)` depending on the answer:
  ```java
  Employee emp;
  if (isManager.equalsIgnoreCase("yes")) {
      emp = new Manager(name, baseSalary, bonus);
  } else {
      emp = new Employee(name, baseSalary);
  }
  ```
- Call `emp.calculatePay()` on the `Employee`-typed variable and display the result. The correct version (base-only or base-plus-bonus) must run automatically based on the object actually created — do not call any `Manager`-specific method directly.

---

## Sample Run

```text
Employee Setup
----------------
Is this employee a manager? (yes/no): yes
Enter name: Dana
Enter base salary: 55000.00
Enter bonus: 5000.00

Employee Report
-----------------
Dana's Pay: $60000.00
```

A second run answering `no` (and skipping the bonus prompt) should display `Dana's Pay: $55000.00` using the same `emp.calculatePay()` call — the `Employee` and `Manager` versions of the method are never chosen explicitly in `main`.

---

## Restrictions

- No arrays or `ArrayList`.
- No external libraries (other than `Scanner`, which is part of core Java).
- Neither `Employee.java` nor `Manager.java` may contain a `main` method — all logic runs through `EmployeeDemo`.
- Fields must be `private`; access them only through constructors, getters, and `calculatePay()`.
- `Manager`'s constructor must call `super(...)` rather than repeating `Employee`'s field assignments.
- `Manager`'s `calculatePay()` must call `super.calculatePay()` and build on it — it must not recompute the base salary itself.
- The variable holding the employee in `main` must be declared as type `Employee`, even when it holds a `Manager` object.
- No values may be hard-coded — all must come from `Scanner` input.

---

## Compile & Run

```bash
javac EmployeeDemo.java
java EmployeeDemo
```

---

## Submission
zip the work folder and upload for submission.
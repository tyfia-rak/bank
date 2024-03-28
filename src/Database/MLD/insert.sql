-------Account-------
INSERT INTO "Account" (FIRST_NAME, LAST_NAME, BIRTHDAY, BANK_BALANCE, BANK_NAME, SALARY_AMOUNT,OVERDRAW)
VALUES ('John', 'Doe', '1990-05-15', 50000.00, 'ABC Bank', 6000.00,true),
       ('Jane', 'Smith', '1985-12-28', 75000.00, 'ABC Bank', 8000.00,false),
       ('Robert', 'Johnson', '1982-09-10', 60000.00, 'XYZ Bank', 7000.00,false),
       ('Mary', 'Williams', '1995-03-22', 45000.00, 'XYZ Bank', 5500.00,false),
       ('Michael', 'Brown', '1998-07-05', 70000.00, 'ABC Bank', 9000.00,false);
----------------------

--------Retreat-------
INSERT INTO "Retreat" (AMOUNT, DATE_TRANSACTION, id_account)
VALUES (1000.00, '2024-03-01', 1),
       (500.00, '2024-03-05', 2),
       (1200.00, '2024-03-10', 3),
       (800.00, '2024-03-15', 4),
       (2000.00, '2024-03-20', 5);
----------------------

-------Loans_bank_interest---
INSERT INTO "Loans_bank_interest" (LOANS, INTEREST, id_account)
VALUES (15000.00, 2000.00, 1),
       (10000.00, 1200.00, 2),
       (20000.00, 2500.00, 3),
       (12000.00, 1800.00, 4),
       (18000.00, 2200.00, 5);
-----------------------------

------Other bank------
INSERT INTO "Other_bank" (ID, AMOUNT, BANK_NAME, TRANSFER_REASON, EFFECTIVE_DATE, REGISTRATION_DATE, id_account)
VALUES ('123456789', 500.00, 'External Bank A', 'Purchase', '2024-03-02', '2024-03-01', 1),
       ('987654321', 800.00, 'External Bank B', 'Expense', '2024-03-06', '2024-03-05', 2),
       ('456789012', 1200.00, 'External Bank C', 'Investment', '2024-03-11', '2024-03-10', 3),
       ('789012345', 600.00, 'External Bank D', 'Miscellaneous', '2024-03-16', '2024-03-15', 4),
       ('234567890', 1500.00, 'External Bank E', 'Entertainment', '2024-03-21', '2024-03-20', 5);
------------------------


------------Transaction------------
INSERT INTO "Transaction" (ID, DATE_TRANSACTION, REFERENCE, MOTIF, CREDIT, DEBIT, id_transaction)
VALUES (1, '2024-03-01', 'REF123', 'Salary Payment', 6000.00, 0.00, 1),
       (2, '2024-03-05', 'REF456', 'Purchase', 0.00, 500.00, 2),
       (3, '2024-03-10', 'REF789', 'Investment', 0.00, 1200.00, 3),
       (4, '2024-03-15', 'REF012', 'Expense', 0.00, 800.00, 4),
       (5, '2024-03-20', 'REF345', 'Miscellaneous', 0.00, 2000.00, 5);
-------------------------------------

    {
  "fist_name": "Rado",
  "last_name": "dslfkj",
  "birthday": "23-09-04",
  "bank_balance": 5000.00,
  "bank_name": "qslf",
  "salary_amount": 233300.00
}

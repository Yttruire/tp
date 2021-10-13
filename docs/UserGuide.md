---
layout: page
title: User Guide
---

CSBook is a **desktop app for teaching assistants (TAs) to manage their students, optimized for use via a Command Line Interface** (CLI) while still having the
benefits of a Graphical User Interface (GUI). If you can type fast, CSBook can get your student management tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `CSBook.jar` from [here](https://github.com/AY2122S1-CS2103T-T09-3/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for CSBook.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all students.

   * **`add`**`n/Jia Xian t/@albino_monkii e/albinomonkey@u.nus.edu g/CS2103T` : Adds a student named `Jia Xian` to CSBook

   * **`delete`**`3` : Deletes the 3rd student shown in the current list.

   * **`clear`** : Deletes all students.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Parameters can be in any order.<br>
<<<<<<< HEAD
  e.g. if the command specifies `n/NAME p/TELEGRAM_HANDLE`, `p/TELEGRAM_HANDLE n/NAME` is also acceptable.
=======
  e.g. if the command specifies `n/NAME t/TELEGRAM_HANDLE`, `t/TELEGRAM_HANDLE n/NAME` is also acceptable.
>>>>>>> ff2a7f5e7e87f9b02e1a6e604ac83958baa27998

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `t/albino_monkii t/albino_api`, only `t/albino_api` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a student: `add`

Adds a student to the CSBook.

<<<<<<< HEAD
Format: `add n/NAME p/TELEGRAM_HANDLE e/EMAIL a/ADDRESS [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>
=======
Format: `add n/NAME t/TELEGRAM_HANDLE e/NUS_EMAIL g/GROUP_NAME`
>>>>>>> ff2a7f5e7e87f9b02e1a6e604ac83958baa27998

Examples:
* `add n/Jia Xian t/@albino_monkii e/albinomonkey@u.nus.edu g/CS2103T`
* `add n/Jun Wei t/@albino_api e/albinoape@u.nus.edu g/CS2101`

### Listing all students : `list`

Shows a list of all students in the CSBook.

Format: `list`

### Editing a student : `edit`

Edits an existing student in the CSBook.

<<<<<<< HEAD
Format: `edit INDEX [n/NAME] [p/TELEGRAM_HANDLE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`
=======
Format: `edit INDEX [n/NAME] [t/TELEGRAM_HANDLE] [e/NUS_EMAIL] [g/GROUP_NAME]`
>>>>>>> ff2a7f5e7e87f9b02e1a6e604ac83958baa27998

* Edits the student at the specified INDEX. The index refers to the index number shown in the displayed student list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
<<<<<<< HEAD
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the telegramHandle number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.
=======
*  `edit 1 t/@albino_monkey e/e0540014X@u.nus.edu` Edits the telegram handle and email address of the 1st student to be `@albino_monkey` and `e0540014X@u.nus.edu` respectively.
*  `edit 2 n/Jiaxian` Edits the name of the 2nd student to be `Jiaxian`.
>>>>>>> ff2a7f5e7e87f9b02e1a6e604ac83958baa27998

### Locating students by name: `find`

Finds students whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Students matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Deleting a student : `delete`

Deletes the specified student from CSBook.

Format: `delete INDEX`

* Deletes the student at the specified `INDEX`.
* The index refers to the index number shown in the displayed student list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd student in CSBook.
* `find Betsy` followed by `delete 1` deletes the 1st student in the results of the `find` command.

### View details of a group
Finds and displays details about a group, including the group description, 
number of students and some details about each student in the group .

Format: `viewgroup GROUPNAME`

Examples:
* `viewgroup CS2103T` displays the group's description and its students.
  ![result for `viewgroup CS2103T`](images/viewGroupCS2103T.png)


### Listing all groups : `listgroups`

Shows a list of all groups in the CSBook.

Format: `listgroups`

Examples:
* `listgroups` displays a list of all the groups, including their group description and number of students in them.
  ![result for `listgroups`](images/listGroups.png)

### Clearing all entries : `clear`

Clears all entries from CSBook.

Format: `clear`

### Creating a group: `addgroup`

Creates a group with the given group name and given description so that students can be added into it. 

Format: `addgroup n/GROUPNAME d/DESCRIPTION`

* Creates a group with the specified `GROUPNAME` and `DESCRIPTION`.

Examples:
* `addgroup n/CS2103T d/Software engineering mod` creates a group called `CS2103T` and the description `Software engineering mod` 
where students can be added into.

### Delete Group: deletegroup

Deletes the group with the specified group name.

Format: `deletegroup GROUPNAME`

* Deletes the group with the specified `GROUPNAME`.

Examples:
* `deletegroup CS2103T` deletes the group CS2103T.

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

CSBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

CSBook data are saved as a JSON file `[JAR file location]/data/CSBook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, CSBook will discard all data and start with an empty data file at the next run.
</div>

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
<<<<<<< HEAD
**Add** | `add n/NAME p/TELEGRAM_HANDLE e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/TELEGRAM_HANDLE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
=======
**Add** | `add n/NAME t/TELEGRAM_HANDLE e/NUS_EMAIL g/GROUPNAME` <br> e.g., `add n/Jia Xian t/albino_monkii e/albinomonkey@u.nus.edu g/CS2103T`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [t/TELEGRAM_HANDLE] [e/NUS_EMAIL] `<br> e.g.,`edit 1 t/@albino_monkey e/e0540014X@u.nus.edu`
**List** | `list` 
>>>>>>> ff2a7f5e7e87f9b02e1a6e604ac83958baa27998
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**Add Group** | `addgroup GROUPNAME`
**Delete Group** | `deletegroup GROUPNAME`
**View Group** | `viewgroup GROUPNAME`
**List Groups** | `listgroups`
**Help** | `help`

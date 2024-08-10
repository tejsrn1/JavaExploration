
### **UNIX/Linux Basics**

**Introduction:**
- There are various Unix variants like Solaris Unix and Linux (free).
- The OS is composed of the Kernel, which is the heart of the OS, directly interacting with hardware.
- Users interact with the Kernel via the Shell, a utility that processes user commands.
- Commands and Utilities: Unix systems provide over 250 commands (e.g., `cp`, `mv`, `cat`, `grep`).
- Files and Directories: Organized into a tree-like filesystem.
- `/etc/profile`: Maintained by the System Admin, it contains shell initialization info required by all users.

### **File Management**

**Types of Files:**
- **Ordinary Files:** Contain data, text, etc.
- **Directory Files:** Store both special and ordinary files, similar to folders.
- **Special Files:** Provide access to hardware such as hard drives, CD-ROMs, modems.

**Listing Files:**
- `$ ls`: Lists files and directories in the current directory.
- `$ ls -l`: Provides detailed information about listed files.
  - **First Column:** File type and permissions.
  - **Second Column:** Number of memory blocks taken by the file/directory.
  - **Third Column:** Owner of the file.
  - **Fourth Column:** Group owner of the file.
  - **Fifth Column:** Size in bytes.
  - **Sixth Column:** Date and time of creation or modification.
  - **Seventh Column:** File or directory name.
  - File type indicators:
    - `d`: Directory
    - `-`: Regular file (text, binary, executable)
    - `b`: Block device file (physical device)
    - `c`: Character device file (e.g., row input/output)
    - `l`: Symbolic link
    - `p`: Named pipe (interprocess communication)
  
**Hidden Files:**
- Files with names starting with `.` (e.g., `.profile`, `.rhosts`).
- `$ ls -a`: Lists all files, including hidden ones.

**File Operations:**
- **Create/Edit:** `$ vi filename` (Use `i` to start editing).
- **View:** `$ cat filename`
- **Word Count:** `$ wc filename`
- **Copy:** `$ cp sourcefile destinationfile`
- **Rename:** `$ mv oldfilename newfilename`
- **Delete:** `$ rm filename` (To delete multiple files: `$ rm file1 file2 file3`).

**Search Files:**
- **Pipe (`|`) and `grep`:** 
  - Example: `$ ls -l | grep "Aug"` (Lists files modified in August).
  - Case-insensitive search: `$ ls -l | grep -i "pattern"`
  - Sorting by size: `$ ls -l | grep "pattern" | sort +4n`

### **Directory Management**

**Basic Commands:**
- **Tree Structure:** Files and directories are organized in a tree structure under the root `/`.
- **Home Directory:** The default starting directory after login.
- **Change Directory:**
  - `$ cd ~` or `$ cd ~username`: Moves to the home directory.
  - `$ cd -`: Moves to the last directory.
  - `$ cd /usr/local/bin`: Moves to the specified directory.
- **Path Types:**
  - **Absolute Path:** Starts with `/` (e.g., `/etc/passwd`).
  - **Relative Path:** Does not start with `/` (e.g., `chem/notes`).
- **Directory Operations:**
  - **Create:** `$ mkdir dirname`
  - **Create with Parent Directories:** `$ mkdir -p /path/to/dirname`
  - **Remove:** `$ rmdir dirname`
  - **Rename:** `$ mv olddirname newdirname`

### **File Permissions**

**Attributes:**
- Every file has permissions for the **Owner**, **Group**, and **Others** (World).
- Example: `-rwxr-xr--`
  - **User (Owner) Permission:** `rwx` (read, write, execute).
  - **Group Permission:** `r-x` (read, execute).
  - **Others Permission:** `r--` (read).

**Changing Permissions (`chmod`):**
- **Symbolic Mode:**
  - `$ chmod o+wx filename` (Add write/execute permission for others).
  - `$ chmod u-x filename` (Remove execute permission for the user).
  - `$ chmod g=rx filename` (Set read/execute permission for the group).
- **Absolute Mode:** Uses numbers to specify permissions.
  - `$ chmod 755 filename` (Owner: read, write, execute; Group/Others: read, execute).

**Changing Ownership:**
- `$ chown username filename`: Changes the file's owner.
- `$ chgrp groupname filename`: Changes the file's group.

**Special Permissions:**
- **SUID and SGID:** Allow a program to execute with the privileges of the owner or group.
- Example: `-r-sr-xr-x` indicates that SUID is set and the command is owned by the root.

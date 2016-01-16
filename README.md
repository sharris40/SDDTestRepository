# SDDTestRepository
This repository is only a test. Use it for practicing.

## Using This Repository
1.  Navigate to a directory in which you would like to store repositories.
2.  Type the following command in the console:

    ```
    git clone git@github.com:sharris40/SDDTestRepository.git
    ```

    This will create a folder for the repository and copy all the files to it.

3.  Change to the repository.

4.  Configure your identity with the commands `git config user.name "*My Name*"` and `git config user.email "*my.email@example.com*"`. If you want your identity to apply to all repositories, add `--global` after `git config`.

5.  Create a branch with `git branch *my_branch*`. This is your local branch. You will make all changes in this branch.

6.  Switch to the branch with `git checkout *my_branch*`. You will need to type this whenever you want to make changes.

7.  Make any changes to the repository. Add, edit, and delete files just as you would any normal files.

8.  For any files you added, type `git add *file_path*`. You can add an entire directory by specifying the name of the directory as the file path.

9.  When you make a change, type `git commit -a -m "*Comment*"`. Write a comment that describes your changes.

    The `-a` will cause git to detect any files you changed and removed, but it will not catch any new files. This is why `git add` is needed when you add a file. You should do this after every major change you make. If you do not want to commit an edited file, omit the `-a`, and manually add the files you do want to commit.

    Do not make multiple unrelated changes and commit them all at once; commit each change individually.

10. When you have finished making changes, switch back to the main branch with the command `git checkout master` and update it with `git pull`.

11. If Git reports that you are already up-to-date, you can merge the changes. Type `git merge *my_branch*`.

12. If you received updated files, be careful; someone else made changes while you were working. Luckily, Git is smart about file changes and will usually merge the two versions together. However, there are some conflicts that can occur:
  *   *If two people edit the same line:* `git merge` will report a merge conflict. The file will be changed so that it includes both versions of the changes with markers indicating the problematic lines. Edit the file to resolve the conflict, then add it using `git add` and commit the changes with `git commit`.
  *   *If one person edits a file, and another removes it:* Decide whether to add or delete the file, and use `git add` or `git rm` followed by a commit.

    GitHub provides some documentation on conflict resolution [here](https://help.github.com/articles/resolving-a-merge-conflict-from-the-command-line/). You should also look at the documentation for [`git merge`](https://git-scm.com/docs/git-merge).

13. When you have finished, upload the changes with `git push`.

## Markdown
This file is a special file for GitHub. Any directory containing a `README.md` will display some documentation in the GitHub Web page corresponding to the directory. If you want, practice writing README.md files. They're written in a language called [Markdown](https://help.github.com/articles/markdown-basics/).

# DSA Prep

Java-based LeetCode problem-solving workspace.

## Folder structure

Each folder is a DSA topic. Files inside are individual problems — one Java class per problem, no package declarations.

```
arrays+hashing/
two-pointers/
sliding-window/
stack/
binary-search/
linked-list/
trees/
tries/
heap-priority-queue/
backtracking/
graphs/
dynamic-programming/
greedy/
intervals/
math-geometry/
bit-manipulation/
_template/        ← excluded from Java analysis; copy ProblemName.java to start a new problem
```

## Conventions

- File name: `ProblemName.java` in PascalCase matching the class name (e.g. `TwoSum.java`)
- Each file is self-contained: solution method(s) + `main()` for manual test cases
- No package declarations — each topic folder is configured as a source root in `.vscode/settings.json`
- Run with: Code Runner (`Ctrl+Alt+N`) or the Run ▶ button

## Adding a new topic folder

1. Create the folder under `e:\dsa-prep\`
2. Add the folder name to `"java.project.sourcePaths"` in `.vscode/settings.json`

## Goal

NeetCode 150 + blind 75 coverage, focusing on pattern recognition across topics.

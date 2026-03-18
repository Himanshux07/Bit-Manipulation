# Bit Manipulation Master Guide (Java + MAANG Interview Focus)

This repository is a complete roadmap for bit manipulation from basics to interview-level patterns.
If you can solve everything here comfortably, you are in strong shape for MAANG-style DSA rounds.

## Table of Contents

1. [Why Bit Manipulation Matters](#why-bit-manipulation-matters)
2. [Bit Fundamentals](#bit-fundamentals)
3. [Java Integer Model (Must Know)](#java-integer-model-must-know)
4. [Bitwise Operators](#bitwise-operators)
5. [Core Bit Operations](#core-bit-operations)
6. [Golden Identities](#golden-identities)
7. [XOR Master Patterns](#xor-master-patterns)
8. [Counting Bits Efficiently](#counting-bits-efficiently)
9. [Subsets and Bitmasking](#subsets-and-bitmasking)
10. [Bitmask DP](#bitmask-dp)
11. [Greedy + Trie + Bits](#greedy--trie--bits)
12. [Common Interview Pitfalls](#common-interview-pitfalls)
13. [Java Utility Templates](#java-utility-templates)
14. [14 Solved Practice Questions](#14-solved-practice-questions)

## Why Bit Manipulation Matters

- Constant-time hacks for many problems.
- Reduces memory and improves speed.
- Essential in XOR, masks, subsets, DP-on-subsets, and Trie-bit problems.
- Frequently asked in coding rounds because it tests logic depth.

## Bit Fundamentals

- A bit is either `0` or `1`.
- Binary is base 2. Position weights are powers of 2.
- Example:
  - `10` (decimal) = `1010` (binary)
  - Index from right (0-based): `3 2 1 0`
  - Bits:                    `1 0 1 0`

## Java Integer Model (Must Know)

- `int` = 32-bit signed two's complement.
- `long` = 64-bit signed two's complement.
- Two's complement negative:
  - `-x = ~x + 1`
- Shift behavior:
  - `>>` arithmetic right shift (keeps sign bit)
  - `>>>` logical right shift (fills zero)
  - `<<` left shift
- Important:
  - `1 << 31` is negative in `int`.
  - Use `1L << k` when `k` can be 31+.
  - Shift count for `int` is masked by 31, for `long` by 63.

## Bitwise Operators

| Operator | Symbol | Meaning |
|---|---|---|
| AND | `&` | bit is 1 only if both are 1 |
| OR | `|` | bit is 1 if at least one is 1 |
| XOR | `^` | bit is 1 if bits differ |
| NOT | `~` | flips every bit |
| Left Shift | `<<` | multiply by `2^k` (if no overflow) |
| Right Shift | `>>` | divide by `2^k` for non-negative |
| Unsigned Right Shift | `>>>` | logical shift right |

Example:

```java
int a = 5;   // 0101
int b = 3;   // 0011

System.out.println(a & b); // 1  (0001)
System.out.println(a | b); // 7  (0111)
System.out.println(a ^ b); // 6  (0110)
```

## Core Bit Operations

```java
// Check i-th bit
boolean isSet = (n & (1 << i)) != 0;

// Set i-th bit
n = n | (1 << i);

// Clear i-th bit
n = n & ~(1 << i);

// Toggle i-th bit
n = n ^ (1 << i);
```

## Golden Identities

- `n & (n - 1)` removes the rightmost set bit.
- `n & -n` extracts the rightmost set bit.
- `n | (n + 1)` sets the rightmost unset bit.
- `~n & (n + 1)` extracts the rightmost unset bit.

## XOR Master Patterns

Properties:

- `a ^ a = 0`
- `a ^ 0 = a`
- XOR is commutative and associative.

Applications:

1. Single number where others appear twice.
2. Two single numbers where others appear twice.
3. Missing number in range `[0..n]`.
4. Prefix XOR for range queries.

Example: two unique numbers.

```java
int xor = 0;
for (int x : nums) xor ^= x;

int diff = xor & -xor; // rightmost differing bit
int a = 0, b = 0;

for (int x : nums) {
    if ((x & diff) != 0) a ^= x;
    else b ^= x;
}
```

## Counting Bits Efficiently

Built-in:

```java
int c = Integer.bitCount(n);
```

Brian Kernighan:

```java
int count = 0;
while (n != 0) {
    n &= (n - 1);
    count++;
}
```

Time complexity is `O(number of set bits)`.

## Subsets and Bitmasking

For `n` elements, total subsets = `2^n`.

```java
for (int mask = 0; mask < (1 << n); mask++) {
    for (int i = 0; i < n; i++) {
        if ((mask & (1 << i)) != 0) {
            // include arr[i]
        }
    }
}
```

Common mapping:

- bit `i` = whether element `i` is selected.
- mask = current subset state.

## Bitmask DP

Typical state:

- `dp[mask]` or `dp[mask][last]`
- `mask` stores chosen/visited items.

Classic MAANG-style uses:

- Traveling Salesman (TSP)
- Assignment/min-cost matching
- Visiting all nodes shortest path
- Partition/arrangement constraints

Example idea (TSP):

- `dp[mask][u]` = minimum cost to end at `u` after visiting nodes in `mask`.

## Greedy + Trie + Bits

Maximum XOR pair:

- Build binary trie from numbers.
- For each number, greedily try opposite bit at each level from MSB to LSB.
- Complexity: `O(32 * n)`.

## Common Interview Pitfalls

1. Operator precedence:
   - Use `(n & (1 << i)) != 0`, not `n & 1 << i != 0`.
2. Overflow with shifts:
   - Prefer `1L << i` for large `i`.
3. Negative numbers with right shift:
   - Use `>>>` when logical shift is required.
4. Assuming `>>` always divides cleanly:
   - True only for non-negative powers and values.
5. Forgetting two's complement behavior in edge cases.

## Java Utility Templates

```java
public class BitUtils {
    static boolean isSet(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    static int setBit(int n, int i) {
        return n | (1 << i);
    }

    static int clearBit(int n, int i) {
        return n & ~(1 << i);
    }

    static int toggleBit(int n, int i) {
        return n ^ (1 << i);
    }

    static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    static int rightmostSetBit(int n) {
        return n & -n;
    }
}
```

## 14 Solved Practice Questions

I have added a full set of solved problems in separate Java files, split by difficulty:

- Easy (5)
- Medium (5)
- Hard (4)

See:

- [problems-14/README.md](problems-14/README.md)
- [problems-14/easy](problems-14/easy)
- [problems-14/medium](problems-14/medium)
- [problems-14/hard](problems-14/hard)

These 14 problems cover the majority of bit manipulation patterns asked in top product companies.
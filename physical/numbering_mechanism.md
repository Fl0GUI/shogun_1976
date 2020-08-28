[Google Patents](https://patents.google.com/patent/US4083564A/en) 

Fig. 12 is a good illustration on the inner workings of a piece.

**Disclaimer**: The following information was gathered using a single game board. If you have a copy of the board as well and you find different information please make contact or create an issue.

# Pieces:

Numbers are noted with pieces on the bottom left corner of the board when the patent text is towards you. Pieces start facing the opposite side of the board and are rotated 90 degrees clockwise for each number.

### Red Shogun:
`2 2 1 1`

### White shogun:
`2 2 1 1`

### Regular pieces:
4 times `1 4 2 3`
6 times `1 3 4 2`
4 times `2 3 1 4`
The north pole of the magnet in a piece is located between the first and second numbers and the south pole between the third and last numbers. The pieces are evenly distributed between red and yellow.

# Board:
Magnets under the board are positioned in each center of 2x2 board tiles. The magnets are either north pole facing up or south pole facing up. The layout is as follows:

```
N N S S 
N N S S 
S S N N 
S S N N 
```
See the patent for more information.

This means that a piece with `1 4 2 3` as values will have the next values when placed on the board.
```
4 1 4 1 3 2 3 2 
2 3 2 3 1 4 1 4 
4 1 4 1 3 2 3 2 
2 3 2 3 1 4 1 4 
3 2 3 2 4 1 4 1 
1 4 1 4 2 3 2 3 
3 2 3 2 4 1 4 1 
1 4 1 4 2 3 2 3 
```

Converting this to the index of the number would mean:
```
2 1 2 1 4 3 4 3 
3 4 3 4 1 2 1 2 
2 1 2 1 4 3 4 3 
3 4 3 4 1 2 1 2 
4 3 4 3 2 1 2 1 
1 2 1 2 3 4 3 4 
4 3 4 3 2 1 2 1 
1 2 1 2 3 4 3 4 
```
This holds for any piece in the same rotation.

Please don't memorize this in order to cheat.

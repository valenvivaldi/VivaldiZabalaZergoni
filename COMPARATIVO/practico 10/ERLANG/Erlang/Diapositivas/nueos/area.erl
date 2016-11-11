-module(area).
-export([area/1]).

area({square,Side}) -> Side * Side;
area({rectangle,X,Y})->X*Y.

-module(factorial).
     -export([factorial/1]).
     factorial(N) when N == 0 -> 1;
     factorial(N) when N > 0 -> N * factorial(N-1).


-module(areaserver).
-export([start/0,loop/0]).

start() -> spawn(areaserver, loop, []).

loop() -> receive
            {From, Shape} -> From!area:area(Shape),
                            loop()
          end.

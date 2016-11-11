
-module(main).
-export([main/1]).


  main(X) -> Pid =areaserver:start(),
          Pid!{self(),X},
          receive T -> T
          end.

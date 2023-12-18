package com.chess.engine;

public enum Alliance {  //using enum bcoz its typesafe and less constant instances
    WHITE {
        @Override
        public int getDirection() {
            return -1;
        }
    },
    BLACK {
        @Override
        public int getDirection() {
            return 1;
        }
    };

    public abstract int getDirection();

}

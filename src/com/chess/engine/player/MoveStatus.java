package com.chess.engine.player;

public enum MoveStatus {

    DONE {
        @Override
        public boolean isDone() {
            return true;
        }
    },

    ILLEGAL_MOVE {
        @Override
        public isDone() {
            return false;
        }
    },
    LEAVES_PLAYER_IN_CHECK {
        @Override
        public isDone() {
            return false;
        }
    };
    public abstract boolean isDone();
}

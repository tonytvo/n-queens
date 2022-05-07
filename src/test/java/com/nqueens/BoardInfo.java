package com.nqueens;

class BoardInfo {
    private final int _size;

    private BoardInfo(int size) {
        this._size = size;
    }

    public static BoardInfo of(int size) {
        return new BoardInfo(size);
    }

    public int getSize() {
        return _size;
    }
}

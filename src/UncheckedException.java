// Непроверяемое исключение
class SumExceededException extends RuntimeException {
    public SumExceededException(String message) {
        super(message);
    }
}

// Проверяемое исключение
class SecondNumberGreaterException extends Exception {
    public SecondNumberGreaterException(String message) {
        super(message);
    }
}



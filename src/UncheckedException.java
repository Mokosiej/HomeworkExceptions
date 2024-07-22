// Непроверяемое исключение
class UncheckedException extends RuntimeException {
    public UncheckedException(String message) {
        super(message);
    }
}

// Проверяемое исключение
class CheckedException extends Exception {
    public CheckedException(String message) {
        super(message);
    }
}


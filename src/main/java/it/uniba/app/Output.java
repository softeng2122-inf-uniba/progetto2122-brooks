package it.uniba.app;

final class Output {
    private Output() {
    }

    public static void success(final String log) {
        System.out.println("[+]" + log);
    }

    public static void loading(final String log) {
        System.out.println("[!!]" + log);
    }

    public static void error(final String log) {
        System.err.println("[-]" + log);
    }
}

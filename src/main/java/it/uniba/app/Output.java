package it.uniba.app;

class Output
{
    public static void success(String log)
    {
        System.out.println("[+]" + log);
    }

    public static void loading(String log)
    {
        System.out.println("[!!]" + log);
    }

    public static void error(String log)
    {
        System.err.println("[-]" + log);
    }
}
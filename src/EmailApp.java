public class EmailApp {
    public static void main(String[] args) throws Exception {
        Email em1 = new Email("Tori", "Thompson");

        em1.setMailboxCapacity(500);
        em1.setAlternateEmail("torithompson92@hotmail.com");

        System.out.println(em1.showInfo());
    }
}

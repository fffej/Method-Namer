import java.lang.reflect.Method;
import java.util.*;

public class GetMethodNames {

    private static Iterable<String> getMethodNames(final String class_, boolean wordPerLine) {
        try {
            Method[] methods = Class.forName(class_).getDeclaredMethods();
            List<String> names = new ArrayList<String>();
            for (int i=0;i<methods.length;++i) {
                String methodName = methods[i].getName();
                if (methodName.contains("$") || methodName.contains("_")) {
                    continue;
                }
                
                String cleanMethodName = methodName.replaceAll("([A-Z])", " $1").trim();
                String[] words = cleanMethodName.split(" ");

                List<String> orderedWords = new ArrayList<String>();
                StringBuilder accum = new StringBuilder();
                for (String word : words) {
                    word = word.toLowerCase();
                    if (word.length() == 1) {
                        accum.append(word);
                    } else {
                        // Check and reset the accumulator
                        if (accum.length() > 0) {
                            orderedWords.add(accum.toString());
                            accum = new StringBuilder();
                        }
                        orderedWords.add(word);
                    }
                }
            
                if (wordPerLine) {
                    names.addAll(orderedWords);
                }
                else {
                    names.add(join(orderedWords));
                }
            }

            
            return names;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.err);
            return Collections.emptyList();
        }
    }

    public static String join(Iterable<String> o) {
        StringBuilder out = new StringBuilder();
        for (String s : o) {
            out.append(s).append(' ');
        }
        return out.toString();
    }

    boolean hasArg(String[] args, String arg) {
        for (int i=0;i<args.length;++i) {
            if (args[i].equals(arg)) {
                return true;
            }
        }
        return false;
    }

    boo


    public static void main(String[] args) {
        boolean wordPerLine = hasArg(args,"-words");
        boolean outputJson = hasArg(args,"-json");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String className = scanner.next();           

            // Not sure what evilness this class does, but loading it kills the process
            // Code says it just throws an exception, but I can't catch it...
            if (className.equals("org.springframework.core.io.VfsUtils")) {
                continue;
            }

            if (outputJson) {
                System.out.println('[');
            }

            for (String methodName : getMethodNames(className,wordPerLine)) {
                if (!outputJson) {
                    System.out.println(methodName);
                }
                else {
                    String[] words = methodName.split(" ");
                    System.out.print('[');
                    for (int i=0;i<words.length;++i) {
                        words[i] = "'" + words[i] + "'";
                    }
                    System.out.print(join(Arrays.asList(words)));
                    System.out.println(']');
                }
                
            }

            if (outputJson) {
                System.out.println(']');
            }
        }
    }
}
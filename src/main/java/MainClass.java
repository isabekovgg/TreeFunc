import java.io.File;

public class MainClass {
    public static void main(String[] args) {
        File file = new File(args[0]);
        System.out.println(treeFunc(file));
    }

    public static String treeFunc(File file) {
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("argument is not valid");
        }
// in the first try, i tried to pass string into method and modify it
// but string didn't modified in the methods, so pomeyal to StringBuilder
        StringBuilder tree = new StringBuilder();
        int depth = 0;
        directoryRecursion(depth, file, tree);
        return tree.toString();
    }

    public static void directoryRecursion(int depth, File file, StringBuilder tree) {
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("argument is not valid");
        }
        printFile(file, depth, tree);

        for (File fil : file.listFiles()) {
            if (fil.isDirectory()) {
                directoryRecursion(depth + 1, fil, tree);
            } else {
                printFile(fil, depth + 1, tree);
            }
        }
    }

    private static String depthAppender(int depth) {
        String depthAppend = "";
        for (int i = 0; i < depth; i++) {
            depthAppend = depthAppend + "|  ";
        }
        return depthAppend;
    }

    public static void printFile(File file, int depth, StringBuilder tree) {
        tree.append(depthAppender(depth));
        tree.append("==>");
        tree.append(file.getName());
        if (file.isDirectory()) {
            tree.append("(depth : ");
            tree.append(depth);
            tree.append(")");
        }
        tree.append("\n");
    }
}

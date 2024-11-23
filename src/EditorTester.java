import Utils.HtmlContext;
import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class EditorTester {

    private Process editorProcess;

    @BeforeEach
    public void setUp() throws IOException {
        // 启动编辑器进程
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "out/production/htmlLab", "Main");
        processBuilder.redirectErrorStream(true); // 将标准错误合并到标准输出
        editorProcess = processBuilder.start();
    }

    @Test
    public void testInitCommand() throws IOException, InterruptedException {
        // 向编辑器发送 'init' 命令
        sendCommand("init");

        // 获取编辑器返回的输出
//        String output = getOutput();
//        System.out.println("output for init is :\n" + output);
        sendCommand("get-context");
        Thread.sleep(500); // 确保子进程有时间处理命令
        String output = getOutput();
        System.out.println("编辑器输出内容为: " + output);

        // 断言 HTML 内容的 ID 不为 "empty"
        assertTrue(output.contains("initialized html root"));
    }

    @Test
    public void testInsertCommand() throws IOException, InterruptedException {
        // 向编辑器发送插入命令
        sendCommand("insert <div> 1 0 'Hello World'");

        // 获取打印树输出
        sendCommand("print-tree");
        String output = getOutput();
        assertTrue(output.contains("<div id=1>Hello World</div>"), "插入失败");
    }

    @Test
    public void testPrintIndentCommand() throws IOException, InterruptedException {
        // 初始化编辑器
        sendCommand("init");
        Thread.sleep(500);

        // 发送 print-indent 命令
        sendCommand("print-indent 2");
        Thread.sleep(500);
        String output = getOutput();
        System.out.println("Print Indent Output: " + output);

        // 验证输出是否符合预期
        assertTrue(output.contains("<html id=\"root\">"), "Print Indent 输出不正确");
    }

    @Test
    public void testPrintTreeCommand() throws IOException, InterruptedException {
        // 初始化编辑器
        sendCommand("init");
        Thread.sleep(500);

        // 发送 print-tree 命令
        sendCommand("print-tree");
        Thread.sleep(500);
        String output = getOutput();
        System.out.println("Print Tree Output: " + output);

        // 验证输出是否符合预期
        assertTrue(output.contains("html#root"), "Print Tree 输出不正确");
    }

    @AfterEach
    public void tearDown() throws IOException {
        if (editorProcess != null && editorProcess.isAlive()) {
            editorProcess.destroy();
        }
    }

    // 发送命令到编辑器进程
    private void sendCommand(String command) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(editorProcess.getOutputStream()));
        writer.write(command);
        writer.newLine();
        writer.flush();
    }

    private BufferedReader reader;

    private void initializeReader() throws IOException {
        if (reader == null) {
            reader = new BufferedReader(new InputStreamReader(editorProcess.getInputStream()));
        }
    }

    private String getOutput() throws IOException {
        initializeReader();
        StringBuilder output = new StringBuilder();
        while (reader.ready()) { // 检查是否有数据可读
            String line = reader.readLine();
            if (line != null) {
                output.append(line).append("\n");
            }
        }
        return output.toString();
    }

}

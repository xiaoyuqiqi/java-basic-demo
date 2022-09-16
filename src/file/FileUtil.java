package file;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtil {
    private FileUtil() {
    }

    public static void createDir(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static byte[] toByteArray2(String filePath) throws IOException {
        File f = new File(filePath);
        if (!f.exists()) {
            throw new FileNotFoundException(filePath);
        }
        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(f);
            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            channel.read(byteBuffer);
            return byteBuffer.array();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (channel != null) {
                    channel.close();
                }
            } catch (IOException e) {
            }
            try {
                if (fs != null) {
                    fs.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public static boolean deleteDir(String sPath) {
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        //如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        //删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                //删除子文件
                if (file.isFile()) {
                    flag = deleteFile(file.getAbsolutePath());
                    if (!flag) {
                        break;
                    }
                } //删除子目录
                else {
                    flag = deleteDir(file.getAbsolutePath());
                    if (!flag) {
                        break;
                    }
                }
            }
        }
        if (!flag) {
            return false;
        }
        //删除当前目录
        return dirFile.delete();
    }

    /**
     * 删除单个文件
     *
     * @param sPath 被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            boolean delete = file.delete();
            if (delete) {
            }
            flag = true;
        }
        return flag;
    }


    /**
     * @param byteArry 字节数组
     * @param file     要写写入数组的文件
     * @return true or false
     */
    public static boolean saveByteToFile(byte[] byteArry, File file) {
        OutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(byteArry);
            fos.flush();
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                }
            }
        }
    }
}

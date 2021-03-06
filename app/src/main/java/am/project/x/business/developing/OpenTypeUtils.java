package am.project.x.business.developing;

import java.io.File;

import am.util.opentype.FileOpenTypeReader;
import am.util.opentype.OpenTypeParser;
import am.util.opentype.OpenTypeReader;
import am.util.opentype.TableRecord;


/**
 * 字体工具
 * Created by Alex on 2018/9/6.
 */
@SuppressWarnings("all")
public class OpenTypeUtils {

    private OpenTypeUtils() {
        //no instance
    }

    public static void test() {
        final File dir = new File("/system/fonts");
        if (dir.exists() && dir.isDirectory()) {
            // list
            final File[] fonts = dir.listFiles();
            if (fonts != null) {
                for (File font : fonts) {
                    test(font);
                }
            }
        }
//        SortedMap<String, Charset> cs = Charset.availableCharsets();
//        Set<String> keys = cs.keySet();
//        for (String key : keys) {
//            System.out.println("lallalalal-----------------------key:" + key);
//        }
    }

    private static void test(File font) {
        if (font == null)
            return;
        OpenTypeReader reader = null;
        try {
            reader = new FileOpenTypeReader(font);
            final OpenTypeParser parser = new OpenTypeParser();
            parser.parse(reader, TableRecord.TAG_NAME);
        } catch (Exception e) {
            // ignore
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    // ignore
                }
            }
        }
    }
}

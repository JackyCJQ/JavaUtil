package com.jacky.zhengze;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther
 */
public class Test {
    private static final Pattern QUERY_STRING_PATTERN = Pattern.compile("(?<!\\{)(\\?)");

    public static void main(String[] args) {
        String template = "http://localhost:8080/{sdfsdf}?sa=ss&&aa={sdfsdf}";
        Matcher matcher = QUERY_STRING_PATTERN.matcher(template);
        if (matcher.find()) {
            String path = template.substring(0, matcher.start());
            String query = template.substring(matcher.end() - 1);
            ChunkTokenizer tokenizer = new ChunkTokenizer(path);
            while (tokenizer.hasNext()) {
                System.out.println(tokenizer.next());
            }
            System.out.println();
            ChunkTokenizer tokenizer1 = new ChunkTokenizer(query);
            while (tokenizer1.hasNext()) {
                System.out.println(tokenizer1.next());
            }

//            this.parseFragment(path, false);
//            this.parseFragment(query, true);
        }
    }

    static class ChunkTokenizer {

        private List<String> tokens = new ArrayList<>();
        private int index;

        ChunkTokenizer(String template) {
            boolean outside = true;
            int level = 0;
            int lastIndex = 0;
            int idx;

            /* loop through the template, character by character */
            for (idx = 0; idx < template.length(); idx++) {
                if (template.charAt(idx) == '{') {
                    /* start of an expression */
                    if (outside) {
                        /* outside of an expression */
                        if (lastIndex < idx) {
                            /* this is the start of a new token */
                            tokens.add(template.substring(lastIndex, idx));
                        }
                        lastIndex = idx;

                        /*
                         * no longer outside of an expression, additional characters will be treated as in an
                         * expression
                         */
                        outside = false;
                    } else {
                        /* nested braces, increase our nesting level */
                        level++;
                    }
                } else if (template.charAt(idx) == '}' && !outside) {
                    /* the end of an expression */
                    if (level > 0) {
                        /*
                         * sometimes we see nested expressions, we only want the outer most expression
                         * boundaries.
                         */
                        level--;
                    } else {
                        /* outermost boundary */
                        if (lastIndex < idx) {
                            /* this is the end of an expression token */
                            tokens.add(template.substring(lastIndex, idx + 1));
                        }
                        lastIndex = idx + 1;

                        /* outside an expression */
                        outside = true;
                    }
                }
            }
            if (lastIndex < idx) {
                /* grab the remaining chunk */
                tokens.add(template.substring(lastIndex, idx));
            }
        }

        public boolean hasNext() {
            return this.tokens.size() > this.index;
        }

        public String next() {
            if (hasNext()) {
                return this.tokens.get(this.index++);
            }
            throw new IllegalStateException("No More Elements");
        }
    }

    @org.junit.Test
    public void test() {
        double everyDayPrice = 0.1;
        DecimalFormat df = new DecimalFormat("#.00");
        String price = df.format(everyDayPrice);
        System.out.println(price);
    }

    @org.junit.Test
    public void test11() {
        LocalDateTime expirationTime = LocalDateTime.now();
        String format = expirationTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm"));
        System.out.println(format);
    }


}

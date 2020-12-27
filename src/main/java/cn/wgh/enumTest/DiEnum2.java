package cn.wgh.enumTest;

/**
 * Created by wgh on 2020/12/27.
 */
public enum DiEnum2 implements Di {
    DI_A {
        public String getDescription() {
            return "我是枚举成员A";
        }

        public int getI() {
            return i;
        }
    },

    DI_B {
        public String getDescription() {
            return "我是枚举成员B";
        }

        public int getI() {
            return i;
        }
    },

    DI_C {
        public String getDescription() {
            return "我是枚举成员C";
        }

        public int getI() {
            return i;
        }
    },

    DI_D {
        public String getDescription() { return "我是枚举成员D"; }

        public int getI() {
            return i;
        }
    };

    private static int i = 2;

}

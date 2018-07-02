    public int calculate(String s) {
        int i = 0, result = 0, preNum = 0, preSign = 1, lastNum = 0;
        boolean waitToMultiply = false, waitToDivide = false;
        while (i < s.length()) {
            char c = s.charAt(i);
            switch (c) {
                case ' ':
                    break;
                case '+':
                    result += preSign * preNum;
                    preNum = 0;
                    preSign = 1;
                    break;
                case '-':
                    result += preSign * preNum;
                    preNum = 0;
                    preSign = -1;
                    break;
                case '*':
                    lastNum = preSign * preNum;
                    waitToMultiply = true;
                    preNum = 0;
                    preSign = 1;
                    break;
                case '/':
                    lastNum = preSign * preNum;
                    waitToDivide = true;
                    preNum = 0;
                    preSign = 1;
                    break;
                default:
                    preNum = preNum * 10 + (c - '0');
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        i++;
                        preNum = preNum * 10 + (s.charAt(i) - '0');
                    }
                    if (waitToMultiply) {
                        if (i + 1 < s.length() && s.charAt(i + 1) != '*' && s.charAt(i + 1) != '/') {
                            result += lastNum * preNum;
                            preNum = 0;
                        } else {
                            preNum = lastNum * preNum;
                        }
                        waitToMultiply = false;
                    } else if (waitToDivide) {
                        if (i + 1 < s.length() && s.charAt(i + 1) != '*' && s.charAt(i + 1) != '/') {
                            result += lastNum / preNum;
                            preNum = 0;
                        } else {
                            preNum = lastNum / preNum;
                        }
                        waitToDivide = false;
                    }
            }
            i++;
        }
        if (preNum != 0) {
            result += preSign * preNum;
        }
        return result;
    }

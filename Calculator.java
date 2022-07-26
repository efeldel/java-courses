public class Calculator {
    private int result;

    public void add(int... params) {
        for (Integer param : params) this.result += param;
    }

    public void sub(int... params) {
        this.result = params[0];
        for (int i = 1; i < params.length; i++) {
            this.result -= params[i];
        }
    }

    public void mul(int... params) {
        this.result = 1;
        for (Integer param : params) this.result *= param;
    }

    public void div(int... params) {
        this.result = params[0];
        for (int i = 1; i < params.length; i++) {
            this.result /= params[i];
        }
    }

    public int getResult() {
        return this.result;
    }

    public void cleanResult() {
        this.result = 0;
    }
}

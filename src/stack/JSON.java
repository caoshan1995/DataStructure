package stack;

import java.util.ArrayList;
import java.util.Scanner;

public class JSON {
	static char[] JSON = null;
	static int INDEX = 0;
	static int error[] = new int[5];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		char[] tempJson = S.toCharArray();
		JSON = new char[tempJson.length];
		for (int i = 0, j = 0; i < S.length(); i++) {
			if (!isAlphabet(tempJson[i])) {
				JSON[j++] = tempJson[i];
			}
		}
		isJson();
		for (int i = 0; i < 5; i++) {
			System.out.println(error[i]);
		}
	}

	public static boolean isJson() {

		return isObject();
	}

	public static boolean isKeyValue() {
		isKey();
		if (JSON[INDEX] != ':') {
			;
		}
		INDEX++;
		isValue();
		if (JSON[INDEX] == ',') {
			INDEX++;
			if (!isObject()) {
				error[4] = 1;
			}

		}
		return true;
	}

	public static boolean isValue() {
		if (JSON[INDEX] == '"' && JSON[INDEX + 1] != '"') {
			error[3] = 1;
			INDEX++;
		} else if (JSON[INDEX] == '[') {
			INDEX++;
			isObject();
			if (JSON[INDEX] != ']') {
				error[3] = 1;
				INDEX++;
			}
		}
		INDEX += 2;
		return true;
	}

	public static boolean isObject() {
		boolean flag = true;
		if (JSON[INDEX] != '{') {
			error[2] = 1;
			flag = false;
		}
		INDEX++;
		isKeyValue();

		if (JSON[INDEX] != '}') {
			error[2] = 1;
			flag = false;
		}

		if (JSON[INDEX] == ',') {
			if (!isKeyValue()) {
				error[4] = 1;
				flag = false;
			}
		}

		return flag;
	}

	public static boolean isKey() {
		if (JSON[INDEX] == '"' && JSON[INDEX + 1] == '"') {
			INDEX += 2;
			return true;
		} else {
			error[3] = 1;
			return false;
		}
	}

	public static boolean isAlphabet(char c) {
		if ('a' <= c && c <= 'z')
			return true;
		else
			return false;
	}
}

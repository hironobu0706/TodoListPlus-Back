package com.example.demo.util;

import java.security.MessageDigest; // SHA-256を使用するためのクラス
import java.security.NoSuchAlgorithmException; // 例外処理のためのクラス

public class Hash {
    // 文字列をSHA-256でハッシュ化するメソッド
    public static String hashString(String input) {
        try {
            // SHA-256のMessageDigestインスタンスを取得
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // 入力文字列をバイト配列に変換
            byte[] hashBytes = digest.digest(input.getBytes()); // ハッシュ化を実行
            // バイト配列を16進数の文字列に変換
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b); // バイトを16進数に変換
                if (hex.length() == 1) {
                    hexString.append('0'); // 1桁の場合は0を追加
                }
                hexString.append(hex); // 16進数を追加
            }
            return hexString.toString(); // ハッシュ化された文字列を返す
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e); // 例外が発生した場合はRuntimeExceptionをスロー
        }
    }
}
package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.R;

public class MainActivity extends AppCompatActivity {
    //buton tanımları
    Button
            btnSifir,
            btnBir,
            btnIki,
            btnUc,
            btnDort,
            btnBes,
            btnAlti,
            btnYedi,
            btnSekiz,
            btnDokuz,
            btnTopla,
            btnCikar,
            btnBolu,
            btnCarp,
            btnEsit,
            btnNokta,
            btnArtieksi,
            btnTemizle;
    //gerekli parametreler
    Double ilkSayi;
    TextView hesapEkrani;
    Boolean virgulDurum;
    String islemDurum;
    Double temp;
    int i, j, esayac, esayacsayi;
    Double sum;
    String diziSembol[] = new String[10];
    double diziSayi[] = new double[10];
    String diziSembolHesapla[] = new String[10];
    double diziSayiHesapla[] = new double[10];
    boolean esittirsonrasıkontrol = false;
    boolean sadececarpma = true;
    boolean sadecebolme = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//butonları idlerini aldım ve parametrelere eşitledim
        btnEsit = findViewById(R.id.esittir);
        btnCikar = findViewById(R.id.eksi);
        btnTopla = findViewById(R.id.arti);
        btnCarp = findViewById(R.id.carpi);
        btnBolu = findViewById(R.id.bolu);
        btnArtieksi = findViewById(R.id.artıbolueksi);
        btnSifir = findViewById(R.id.sifir);
        btnNokta = findViewById(R.id.nokta);
        btnTemizle = findViewById(R.id.temizle);
        btnBir = findViewById(R.id.bir);
        btnIki = findViewById(R.id.iki);
        btnUc = findViewById(R.id.uc);
        btnDort = findViewById(R.id.dort);
        btnBes = findViewById(R.id.bes);
        btnAlti = findViewById(R.id.alti);
        btnYedi = findViewById(R.id.yedi);
        btnSekiz = findViewById(R.id.sekiz);
        btnDokuz = findViewById(R.id.dokuz);
        hesapEkrani = findViewById(R.id.ekran);
//gerekli 0 a eşitlemeler
        hesapEkrani.setText("0");
        ilkSayi = 0.0;
        virgulDurum = false;
        islemDurum = "0";
        temp = 0.0;
        i = 0;
        j = 0;
        sum = 0.0;
        esayac = 0;
        esayacsayi = 0;
        //gerekli click fonksiyonları
        btnEsit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("=");
            }
        });
        btnTopla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("+");
            }
        });
        btnCikar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("-");
            }
        });
        btnCarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("*");
            }
        });
        btnBolu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("/");
            }
        });
        btnTemizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("sifirla");
            }
        });
        btnNokta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL(".");
            }
        });
        btnArtieksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("+/-");
            }
        });
        btnSifir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(0);
            }
        });
        btnBir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(1);
            }
        });
        btnIki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(2);
            }
        });
        btnUc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(3);
            }
        });
        btnDort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(4);
            }
        });
        btnBes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(5);
            }
        });
        btnAlti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(6);
            }
        });
        btnYedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(7);
            }
        });
        btnSekiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(8);
            }
        });
        btnDokuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(9);
            }
        });
    }

    ;

    //rakam giriş için fonksiyon
    private void TIKLA_NUMARA(int sayi) {
        if (hesapEkrani.getText().toString() == "0") {
            hesapEkrani.setText("");
        } else if (
                hesapEkrani.getText().toString() == "+" ||
                        hesapEkrani.getText().toString() == "*" ||
                        hesapEkrani.getText().toString() == "/" ||
                        hesapEkrani.getText().toString() == "-" ||
                        hesapEkrani.getText().toString() == "." ||
                        hesapEkrani.getText().toString() == "+/-"
        ) {
            diziSembol[j] = hesapEkrani.getText().toString();
            j++;
            hesapEkrani.setText("");
        }
        hesapEkrani.setText(hesapEkrani.getText() + String.valueOf(sayi));
    }

    //semboller için gerekli fonksiyonlar
    private void TIKLA_SEMBOL(String sembol) {
        switch (sembol) {
            default: {
                if (hesapEkrani.getText().toString() == "+" || hesapEkrani.getText().toString() == "*"
                        || hesapEkrani.getText().toString() == "/" || hesapEkrani.getText().toString() == "-") {
                    diziSembol[j] = hesapEkrani.getText().toString();
                    if (islemDurum == "*" || islemDurum == "/")
                        ilkSayi = -1 * ilkSayi;

                    hesapEkrani.setText(sembol);
                    islemDurum = sembol;
                } else {
                    if (esittirsonrasıkontrol == true) //eşittire tıklanınca yanına tekrar sayı eklemek için yazılan döngü
                    {
                        if (sum == 0) {
                            diziSayi[i] = Double.parseDouble(hesapEkrani.getText().toString());
                            i++;
                            ilkSayi = Double.parseDouble(hesapEkrani.getText().toString());
                            hesapEkrani.setText(sembol);
                            islemDurum = sembol;
                        } else {
                            i = 0;
                            j = 0;
                            hesapEkrani.setText(sum.toString());
                            sum = 0.0;
                            diziSayi[i] = Double.parseDouble(hesapEkrani.getText().toString());
                            i++;
                            ilkSayi = Double.parseDouble(hesapEkrani.getText().toString());
                            hesapEkrani.setText(sembol);
                            islemDurum = sembol;
                        }

                    } else {
                        diziSayi[i] = Double.parseDouble(hesapEkrani.getText().toString());
                        i++;
                        ilkSayi = Double.parseDouble(hesapEkrani.getText().toString());
                        hesapEkrani.setText(sembol);
                        islemDurum = sembol;
                    }


                }
            }
            break;
            case "sifirla": {
                ilkSayi = 0.0;
                hesapEkrani.setText("0");
                islemDurum = "0";
                sum = 0.0;
                esayac = 0;
                esayacsayi = 0;
                esittirsonrasıkontrol = false;
                temp = 0.0;
                sadececarpma = true;
                sadecebolme = true;
                for (int z = 0; i < 10; i++) {
                    diziSayi[i] = 0;
                    diziSayiHesapla[i] = 0;
                    diziSembol[i] = "";
                    diziSembolHesapla[i] = "";
                }
                i = 0;
                j = 0;

            }
            break;
            case "=": {//eşittirden sonra hesaplamalar için yazılan döngüler
                if (hesapEkrani.getText().toString() == "+" || hesapEkrani.getText().toString() == "*"
                        || hesapEkrani.getText().toString() == "/" || hesapEkrani.getText().toString() == "-") {

                } else {
                    diziSayi[i] = Double.parseDouble(hesapEkrani.getText().toString());
                    hesapEkrani.setText("");
                    for (int e = 0; e < j; e++) { //işlem önceliği için çarpmaları ve bölmeleri tek sayı haline getirip topluyoruz
                        if (diziSembol[e] == "*") {
                            sadecebolme = false;
                            if (e > 1) {
                                if (diziSembol[e + 1] == "*" || diziSembol[e + 1] == "/") {
                                    if (diziSembol[e + 1] == "*") {
                                        diziSayiHesapla[esayacsayi] = diziSayi[e] * diziSayi[e + 1] * diziSayi[e + 2];
                                    } else {
                                        diziSayiHesapla[esayacsayi] = diziSayi[e] * diziSayi[e + 1] / diziSayi[e + 2];
                                    }
                                    esayac++;
                                } else if (diziSembol[e - 1] == "*" || diziSembol[e - 1] == "/") {
                                } else {
                                    diziSayiHesapla[esayacsayi] = diziSayi[e] * diziSayi[e + 1];
                                    esayacsayi++;
                                }
                            } else {
                                if (e == 0) {
                                    diziSayiHesapla[esayacsayi] = diziSayi[e] * diziSayi[e + 1];
                                    esayacsayi++;
                                } else {
                                    diziSayiHesapla[esayacsayi - 1] = diziSayi[e] * diziSayi[e + 1];
                                    esayacsayi++;
                                }


                            }
                        }
                        if (diziSembol[e] == "/") {
                            sadececarpma = false;
                            if (e > 1) {
                                if (diziSembol[e + 1] == "*" || diziSembol[e + 1] == "/") {
                                    if (diziSembol[e + 1] == "*") {
                                        diziSayiHesapla[esayacsayi] = diziSayi[e] / diziSayi[e + 1] * diziSayiHesapla[e + 2];
                                    } else {
                                        diziSayiHesapla[esayacsayi] = diziSayi[e] / diziSayi[e + 1] / diziSayiHesapla[e + 2];
                                    }
                                    esayacsayi++;
                                } else if (diziSembol[e - 1] == "*" || diziSembol[e - 1] == "/") {

                                } else {
                                    diziSayiHesapla[esayacsayi] = diziSayi[e] / diziSayi[e + 1];
                                    esayacsayi++;
                                }
                            } else {
                                if (e == 0) {
                                    diziSayiHesapla[esayacsayi] = diziSayi[e] / diziSayi[e + 1];
                                    esayacsayi++;
                                } else {
                                    diziSayiHesapla[esayacsayi-1] = diziSayi[e] / diziSayi[e + 1];
                                    esayacsayi++;
                                }

                            }

                        }
                        if (diziSembol[e] == "+") {
                            sadecebolme = false;
                            sadececarpma = false;
                            if (e == 0) {
                                diziSayiHesapla[esayacsayi] = diziSayi[e];
                                diziSayiHesapla[esayacsayi + 1] = diziSayi[e + 1];
                                diziSembolHesapla[esayac] = diziSembol[e];
                                esayac++;
                                esayacsayi++;
                                esayacsayi++;
                            } else {
                                diziSayiHesapla[esayacsayi] = diziSayi[e + 1];
                                diziSembolHesapla[esayac] = diziSembol[e];
                                esayac++;
                                esayacsayi++;
                            }

                        }
                        if (diziSembol[e] == "-") {
                            sadecebolme = false;
                            sadececarpma = false;
                            if (e == 0) {
                                diziSayiHesapla[esayacsayi] = diziSayi[e];
                                diziSayiHesapla[esayacsayi + 1] = diziSayi[e + 1];
                                diziSembolHesapla[esayac] = diziSembol[e];
                                esayac++;
                                esayacsayi++;
                                esayacsayi++;
                            } else {
                                diziSayiHesapla[esayacsayi] = diziSayi[e + 1];
                                diziSembolHesapla[esayac] = diziSembol[e];
                                esayac++;
                                esayacsayi++;
                            }
                        }
                    }
                    if (sadececarpma == true) //tek çarpma ve tek bölme olması durumunda bu döngü toplamalarını gerçekleştiriyor
                    {
                        sum = diziSayi[0];
                    }
                    for (int g = 1; g <= j; g++) {
                        if (sadececarpma == true) {
                            sum *= diziSayi[g];
                        }
                    }
                    if (sadecebolme == true) {
                        sum = diziSayi[0];
                    }
                    for (int g = 1; g <= j; g++) {
                        if (sadecebolme == true) {
                            sum /= diziSayi[g];
                        }
                    }

                    for (int e = 0; e < esayac; e++) {
                        if (diziSembolHesapla[e] == "+") {

                            if (e == 0) {
                                sum += diziSayiHesapla[e] + diziSayiHesapla[e + 1];
                            } else {
                                sum += diziSayiHesapla[e + 1];
                            }
                        }
                        if (diziSembolHesapla[e] == "-") {

                            if (e == 0) {
                                sum += diziSayiHesapla[e] - diziSayiHesapla[e + 1];
                            } else {
                                sum -= diziSayiHesapla[e + 1];
                            }
                        }
                    }
                    for (int z = 0; z < j; z++) { //sembol ve rakam dizileri için gerekli döngüler (yan yana yazdırmak için)
                        if (diziSembol[z] == "+") {

                            if (z == 0) {
                                hesapEkrani.setText(hesapEkrani.getText().toString() + diziSayi[z] + "+" + diziSayi[z + 1]);
                            } else {
                                hesapEkrani.setText(hesapEkrani.getText().toString() + "+" + diziSayi[z + 1]);
                            }
                            esittirsonrasıkontrol = true;
                        } else if (diziSembol[z] == "-") {
                            if (z == 0) {
                                hesapEkrani.setText(hesapEkrani.getText().toString() + diziSayi[z] + "-" + diziSayi[z + 1]);
                            } else {
                                hesapEkrani.setText(hesapEkrani.getText().toString() + "-" + diziSayi[z + 1]);
                            }
                            esittirsonrasıkontrol = true;
                        } else if (diziSembol[z] == "/") {
                            if (z == 0) {
                                hesapEkrani.setText(hesapEkrani.getText().toString() + diziSayi[z] + "/" + diziSayi[z + 1]);
                            } else {
                                hesapEkrani.setText(hesapEkrani.getText().toString() + "/" + diziSayi[z + 1]);
                            }
                            esittirsonrasıkontrol = true;
                        } else if (diziSembol[z] == "*") {
                            if (z == 0) {
                                hesapEkrani.setText(hesapEkrani.getText().toString() + diziSayi[z] + "*" + diziSayi[z + 1]);
                            } else {
                                hesapEkrani.setText(hesapEkrani.getText().toString() + "*" + diziSayi[z + 1]);
                            }
                            esittirsonrasıkontrol = true;
                        } else {
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                    }
                    hesapEkrani.setText(hesapEkrani.getText().toString() + "=" + sum);
                }
            }
            break;
            case ".": {
                hesapEkrani.setText(hesapEkrani.getText().toString() + ".");
                diziSayi[i] = Double.parseDouble(hesapEkrani.getText().toString());
            }
            break;
            case "+/-": {
                hesapEkrani.setText("-" + hesapEkrani.getText().toString());
                diziSayi[i] = -1 * Double.parseDouble(hesapEkrani.getText().toString());
            }
            break;
        }
    }
}

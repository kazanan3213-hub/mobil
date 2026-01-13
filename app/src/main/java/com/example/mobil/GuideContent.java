package com.example.mobil;

import java.util.Arrays;
import java.util.List;

public final class GuideContent {
    private static final List<String> STEPS = Arrays.asList(
            "1) Türkiye'ye giriş yaptıktan sonra ilk 10 gün içinde ikamet başvurusu planla.",
            "2) e-İkamet üzerinden uygun ikamet türünü seç.",
            "3) Başvuru formunu doldur, kaydı tamamla ve randevu al.",
            "4) Gerekli evrakları hazırla.",
            "5) Randevu gününde dosyanla birlikte İl Göç İdaresi'ne git.",
            "6) Değerlendirme sürecini e-İkamet'ten takip et.",
            "7) İkamet kartı PTT kargo ile adresine gönderilir."
    );

    private static final List<String> REQUIRED_DOCUMENTS = Arrays.asList(
            "e-İkamet başvuru formu çıktısı",
            "Pasaport ve fotokopisi (kimlik sayfası ve giriş damgası)",
            "4 adet biyometrik fotoğraf",
            "Geçerli sağlık sigortası (öğrenci ikametinde gerekli olabilir)",
            "Öğrenci belgesi veya üniversite kabul belgesi",
            "İkamet harcı ve kart bedeli ödeme makbuzu",
            "Adres kaydı için kira kontratı veya yurt belgesi",
            "Vergi numarası (gerekli olabilir)"
    );

    private static final String APPOINTMENT_LINK = "https://e-ikamet.goc.gov.tr/";
    private static final String ADDRESS_DIRECTORY_LINK = "https://www.goc.gov.tr/il-goc-idareleri";

    private static final List<Office> ISTANBUL_OFFICES = Arrays.asList(
            new Office(
                    "İstanbul İl Göç İdaresi Müdürlüğü (Merkez)",
                    "Güncel adres ve yönlendirme için resmi listeden kontrol edin."
            ),
            new Office(
                    "İstanbul ilçe göç idaresi adresleri",
                    "Adres listesi: " + ADDRESS_DIRECTORY_LINK
            )
    );

    private GuideContent() {
    }

    public static String build() {
        StringBuilder builder = new StringBuilder();
        builder.append("Yabancı Öğrenci Adayı Rehberi\n\n");
        appendSection(builder, "İzlenecek Adımlar", STEPS);
        appendSection(builder, "Oturum İzni İçin Gerekli Evraklar", REQUIRED_DOCUMENTS);
        builder.append("Randevu Sistemi Linki\n");
        builder.append(APPOINTMENT_LINK).append("\n\n");
        builder.append("İstanbul İl Göç İdaresi Adresleri\n");
        for (Office office : ISTANBUL_OFFICES) {
            builder.append("- ").append(office.name).append("\n");
            builder.append("  ").append(office.address).append("\n");
        }
        builder.append("\n");
        builder.append("Not: Güncel bilgi ve adresler için resmi Göç İdaresi kaynaklarını kontrol edin.");
        return builder.toString();
    }

    private static void appendSection(StringBuilder builder, String title, List<String> items) {
        builder.append(title).append("\n");
        for (String item : items) {
            builder.append("- ").append(item).append("\n");
        }
        builder.append("\n");
    }

    private static final class Office {
        private final String name;
        private final String address;

        private Office(String name, String address) {
            this.name = name;
            this.address = address;
        }
    }
}

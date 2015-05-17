package constructioncompany.conf.factory;

import constructioncompany.domain.Artisan;

import java.util.Map;

/**
 * Created by Yusiry Davids on 5/10/2015.
 */
public class ArtisanFactory {

    public static Artisan createArtisan(Map<String, String> values) {

        Artisan artisan = new Artisan.Builder(values.get("skill")).staffCode(values.get("staffCode")).payCode(values.get("payCode"))
                .addressCode(values.get("addressCode")).IDnumber(values.get("IDnumber")).name(values.get("name")).surname(
                        values.get("surname")).phone(values.get("phone")).build();

        return artisan;

    }

}

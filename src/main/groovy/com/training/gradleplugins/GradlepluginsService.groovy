package  com.training.gradleplugins

import com.google.common.collect.ImmutableList
import com.training.gradleplugins.core.Item
import com.yammer.dropwizard.Service
import com.yammer.dropwizard.assets.AssetsBundle
import com.yammer.dropwizard.config.Bootstrap
import com.yammer.dropwizard.config.Environment
import com.yammer.dropwizard.db.DatabaseConfiguration
import com.yammer.dropwizard.hibernate.HibernateBundle
import com.yammer.dropwizard.hibernate.SessionFactoryFactory
import com.yammer.dropwizard.migrations.MigrationsBundle

class GradlepluginsService extends Service<GradlepluginsConfiguration> {
    public static void main(String[] args) throws Exception {
        new GradlepluginsService().run(args)
    }

    HibernateBundle<GradlepluginsConfiguration> hibernateBundle =
        new HibernateBundle<GradlepluginsConfiguration>(ImmutableList.copyOf([Item]), new SessionFactoryFactory()) {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(GradlepluginsConfiguration configuration) {
                return configuration.databaseConfiguration
            }
        }

    MigrationsBundle<GradlepluginsConfiguration> migrationsBundle =
        new MigrationsBundle<GradlepluginsConfiguration>() {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(GradlepluginsConfiguration configuration) {
                return configuration.databaseConfiguration
            }
        }

    AssetsBundle assetsBundle = new AssetsBundle()

    @Override
    public void initialize(Bootstrap<GradlepluginsConfiguration> bootstrap) {
        bootstrap.with {
            name = 'Gradleplugins'
            addBundle migrationsBundle
            addBundle hibernateBundle
        }
    }



    @Override
    public void run(GradlepluginsConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {  // de aqui corren mis resources

    }
}

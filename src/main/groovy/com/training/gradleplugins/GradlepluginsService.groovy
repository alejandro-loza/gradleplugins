package com.training.gradleplugins

import com.google.common.collect.ImmutableList
import com.training.gradleplugins.auth.ExampleAuthenticator
import com.training.gradleplugins.core.Brand
import com.training.gradleplugins.core.CategoryType
import com.training.gradleplugins.core.Item
import com.training.gradleplugins.core.ItemGroup
import com.training.gradleplugins.core.ItemGroupProfile
import com.training.gradleplugins.core.ItemType
import com.training.gradleplugins.core.User
import com.training.gradleplugins.core.Vertical
import com.training.gradleplugins.db.hibernate.HibernateItemDAO
import com.training.gradleplugins.db.hibernate.ItemGroupDAO
import com.training.gradleplugins.db.hibernate.ItemGroupProfileDAO
import com.training.gradleplugins.db.hibernate.VerticalDAO
import com.training.gradleplugins.resources.HelloGroovyResource
import com.training.gradleplugins.resources.ItemGroupProfileResource
import com.training.gradleplugins.resources.ItemGroupResource
import com.training.gradleplugins.resources.ItemResource
import com.training.gradleplugins.resources.ItemsResource
import com.training.gradleplugins.resources.VerticalResource
import com.yammer.dropwizard.Service
import com.yammer.dropwizard.assets.AssetsBundle
import com.yammer.dropwizard.auth.basic.BasicAuthProvider
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
     List entityes = [Item,ItemGroup, ItemType,ItemGroupProfile,Vertical,Brand,CategoryType]

    private final HibernateBundle<GradlepluginsConfiguration> hibernateBundle =
            new HibernateBundle<GradlepluginsConfiguration>(ImmutableList.copyOf(entityes), new SessionFactoryFactory()) {
        @Override
        public DatabaseConfiguration getDatabaseConfiguration(GradlepluginsConfiguration configuration) {
            return configuration.getDatabaseConfiguration();
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
    public void run(GradlepluginsConfiguration configuration, Environment environment) throws ClassNotFoundException {

        final HibernateItemDAO dao = new HibernateItemDAO(hibernateBundle.getSessionFactory());
        final VerticalDAO verticalDao = new VerticalDAO(hibernateBundle.getSessionFactory());
        final ItemGroupDAO itemGroupDAO = new ItemGroupDAO(hibernateBundle.getSessionFactory());
        final ItemGroupProfileDAO itemGroupProfileDAO = new ItemGroupProfileDAO(hibernateBundle.getSessionFactory());


        environment.addProvider(new BasicAuthProvider<User>(new ExampleAuthenticator(), "SUPER SECRET STUFF"))
//        final DBIFactory factory = new DBIFactory();
//        final DBI jdbi = factory.build(environment, configuration.getDatabaseConfiguration(), "mysql");
//        final ItemDAO dao = jdbi.onDemand(ItemDAO.class);
        environment.addResource(new ItemsResource(dao))
        environment.addResource(new ItemResource(dao))
        environment.addResource(new HelloGroovyResource())
        environment.addResource(new VerticalResource(verticalDao))
        environment.addResource(new ItemGroupResource(itemGroupDAO))
        environment.addResource(new ItemGroupProfileResource(itemGroupProfileDAO))


    }
}

package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.SimpleEntity;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class HibernateMain {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();
        // comenzar transacción
        session.beginTransaction();

        /** //Bloque create
        SimpleEntity entity = new SimpleEntity();
        // lo permite nulo porque así lo hemos indicado en la clase SimpleEntity
        entity.setNombre("Descripción");
        // guardar la entidad
        session.save(entity);
        **/

        /** // Bloque update
        SimpleEntity entityUpdate = new SimpleEntity();
        entityUpdate.setCodigo(2);
        entityUpdate.setNombre("Descripción update");
        session.update(entityUpdate);*/

        /** // Bloque delete
        SimpleEntity entityDelete = new SimpleEntity();
        // la primary key 1
        entityDelete.setCodigo(1);
        session.delete(entityDelete);*/

        /** // Bloque read
        SimpleEntity entityRead = session.get(SimpleEntity.class, 2);
        System.out.println(entityRead.getNombre());*/

        SimpleEntity entity = new SimpleEntity();
        entity.setNombre("Descripción");

        SimpleEntity entityUpdate = new SimpleEntity();
        entityUpdate.setCodigo(2);
        entityUpdate.setNombre("Descripción update 2");


        // guarda o actualiza en función del objeto que recibe
        session.saveOrUpdate(entity);
        session.saveOrUpdate(entityUpdate);


        // realizar el commit de la transacción
        session.getTransaction().commit();
        session.close();
    }

}

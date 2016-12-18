databaseChangeLog = {

    changeSet(author: "Joerg (generated)", id: "1482079968852-1") {
        createTable(tableName: "apiary") {
            column(name: "id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-2") {
        createTable(tableName: "beehive") {
            column(name: "id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "apiary_id", type: "VARCHAR(255)")

            column(name: "beehive_creation_id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "beehive_dissolved_id", type: "VARCHAR(255)")

            column(name: "brood_chamber", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "created", type: "TIMESTAMP") {
                constraints(nullable: "false")
            }

            column(name: "hive_type", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "honey_chamber", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "queen_id", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-3") {
        createTable(tableName: "beehive_action") {
            column(name: "id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "beehive_id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "date", type: "TIMESTAMP") {
                constraints(nullable: "false")
            }

            column(name: "notes", type: "VARCHAR(4000)")

            column(name: "class", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "feed", type: "VARCHAR(255)")

            column(name: "quantity", type: "DECIMAL(19, 2)")

            column(name: "queen_id", type: "VARCHAR(255)")

            column(name: "honey_type", type: "VARCHAR(255)")

            column(name: "water_content", type: "DECIMAL(5, 2)")

            column(name: "brood_chamber", type: "INT")

            column(name: "brutwaben", type: "INT")

            column(name: "cell_capped", type: "INT")

            column(name: "drohnenwaben", type: "INT")

            column(name: "egg", type: "INT")

            column(name: "futterwaben", type: "INT")

            column(name: "honey_chamber", type: "INT")

            column(name: "koenigin_gesehen", type: "BOOLEAN")

            column(name: "larva", type: "INT")

            column(name: "leerwaben", type: "INT")

            column(name: "mittelwaende", type: "INT")

            column(name: "sanftmut", type: "INT")

            column(name: "volksstaerke", type: "INT")

            column(name: "wabensitz", type: "INT")

            column(name: "weiselrichtig", type: "BOOLEAN")

            column(name: "infestation_after_treatment", type: "INT")

            column(name: "lot_number", type: "VARCHAR(255)")

            column(name: "medicine", type: "VARCHAR(255)")

            column(name: "method", type: "VARCHAR(255)")

            column(name: "days", type: "INT")

            column(name: "move_to_id", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-4") {
        createTable(tableName: "beehive_creation") {
            column(name: "id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "apiary_id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "brood_chamber", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "created", type: "TIMESTAMP") {
                constraints(nullable: "false")
            }

            column(name: "has_queen", type: "BOOLEAN")

            column(name: "hive_type", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "honey_chamber", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "notes", type: "VARCHAR(4000)")

            column(name: "queen_id", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-5") {
        createTable(tableName: "beehive_dissolved") {
            column(name: "id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "date", type: "TIMESTAMP") {
                constraints(nullable: "false")
            }

            column(name: "notes", type: "VARCHAR(4000)")
        }
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-6") {
        createTable(tableName: "beehive_measurement") {
            column(name: "id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "beehive_id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "date", type: "TIMESTAMP") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "TIMESTAMP") {
                constraints(nullable: "false")
            }

            column(name: "inside_temperature", type: "DOUBLE") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "TIMESTAMP") {
                constraints(nullable: "false")
            }

            column(name: "outside_humidity", type: "DOUBLE") {
                constraints(nullable: "false")
            }

            column(name: "outside_temperature", type: "DOUBLE") {
                constraints(nullable: "false")
            }

            column(name: "type", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "weight", type: "DOUBLE") {
                constraints(nullable: "false")
            }

            column(name: "weight_difference", type: "DOUBLE")
        }
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-7") {
        createTable(tableName: "queen") {
            column(name: "id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "belegstelle", type: "VARCHAR(255)")

            column(name: "breed", type: "VARCHAR(255)")

            column(name: "color", type: "VARCHAR(255)")

            column(name: "year", type: "INT")

            column(name: "zeichen", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-8") {
        createTable(tableName: "sec_role") {
            column(name: "id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "authority", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-9") {
        createTable(tableName: "sec_user") {
            column(name: "id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "account_expired", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "account_locked", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "enabled", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "password", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "password_expired", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "username", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-10") {
        createTable(tableName: "sec_userrole") {
            column(name: "user_id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "role_id", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-11") {
        addPrimaryKey(columnNames: "id", constraintName: "apiaryPK", tableName: "apiary")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-12") {
        addPrimaryKey(columnNames: "id", constraintName: "beehivePK", tableName: "beehive")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-13") {
        addPrimaryKey(columnNames: "id", constraintName: "beehive_actionPK", tableName: "beehive_action")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-14") {
        addPrimaryKey(columnNames: "id", constraintName: "beehive_creationPK", tableName: "beehive_creation")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-15") {
        addPrimaryKey(columnNames: "id", constraintName: "beehive_dissolvedPK", tableName: "beehive_dissolved")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-16") {
        addPrimaryKey(columnNames: "id", constraintName: "beehive_measurementPK", tableName: "beehive_measurement")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-17") {
        addPrimaryKey(columnNames: "id", constraintName: "queenPK", tableName: "queen")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-18") {
        addPrimaryKey(columnNames: "id", constraintName: "sec_rolePK", tableName: "sec_role")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-19") {
        addPrimaryKey(columnNames: "id", constraintName: "sec_userPK", tableName: "sec_user")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-20") {
        addPrimaryKey(columnNames: "user_id, role_id", constraintName: "sec_userrolePK", tableName: "sec_userrole")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-21") {
        addUniqueConstraint(columnNames: "authority", constraintName: "UC_SEC_ROLEAUTHORITY_COL", tableName: "sec_role")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-22") {
        addUniqueConstraint(columnNames: "username", constraintName: "UC_SEC_USERUSERNAME_COL", tableName: "sec_user")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-23") {
        addForeignKeyConstraint(baseColumnNames: "beehive_id", baseTableName: "beehive_measurement", constraintName: "FK1s2jc337n2kuienv1gyohlfou", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "beehive")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-24") {
        addForeignKeyConstraint(baseColumnNames: "beehive_id", baseTableName: "beehive_action", constraintName: "FK4hbdg6cwlrjmmoo82ialb27gn", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "beehive")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-25") {
        addForeignKeyConstraint(baseColumnNames: "queen_id", baseTableName: "beehive", constraintName: "FKat3khgnvea19n7upc873jn7pt", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "queen")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-26") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "sec_userrole", constraintName: "FKg1dcqd7a0imwfbbt73ad2iqna", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "sec_user")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-27") {
        addForeignKeyConstraint(baseColumnNames: "beehive_creation_id", baseTableName: "beehive", constraintName: "FKg57u0q8iwspyjtforq4qor960", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "beehive_creation")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-28") {
        addForeignKeyConstraint(baseColumnNames: "apiary_id", baseTableName: "beehive", constraintName: "FKgytsitpfdut924y7swll6267h", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "apiary")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-29") {
        addForeignKeyConstraint(baseColumnNames: "beehive_dissolved_id", baseTableName: "beehive", constraintName: "FKhfcixmsrybfamq559pmb22afg", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "beehive_dissolved")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-30") {
        addForeignKeyConstraint(baseColumnNames: "queen_id", baseTableName: "beehive_action", constraintName: "FKn6kdyuldogydcw5dh5p5h7411", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "queen")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-31") {
        addForeignKeyConstraint(baseColumnNames: "queen_id", baseTableName: "beehive_creation", constraintName: "FKn9f0ao5lngiq2ap15vat4yskd", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "queen")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-32") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "sec_userrole", constraintName: "FKo0did7mtfullggl6ujfuufc3p", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "sec_role")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-33") {
        addForeignKeyConstraint(baseColumnNames: "move_to_id", baseTableName: "beehive_action", constraintName: "FKsspfa2fnuu7l3obyr4xxfe8ua", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "apiary")
    }

    changeSet(author: "Joerg (generated)", id: "1482079968852-34") {
        addForeignKeyConstraint(baseColumnNames: "apiary_id", baseTableName: "beehive_creation", constraintName: "FKt7kj18m52t6w7jbxi6qus5o39", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "apiary")
    }
}

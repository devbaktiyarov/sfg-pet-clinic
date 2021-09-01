package com.arsenbaktiyarov.sfgpetclinic.bootstrap;


import com.arsenbaktiyarov.sfgpetclinic.model.Owner;
import com.arsenbaktiyarov.sfgpetclinic.model.Pet;
import com.arsenbaktiyarov.sfgpetclinic.model.PetType;
import com.arsenbaktiyarov.sfgpetclinic.model.Vet;
import com.arsenbaktiyarov.sfgpetclinic.service.OwnerService;
import com.arsenbaktiyarov.sfgpetclinic.service.PetTypeService;
import com.arsenbaktiyarov.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setId(1L);
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setId(1L);
        cat.setName("Dog");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Tony");
        owner.setLastName("Ferguson");
        owner.setAddress("123 Ocean");
        owner.setCity("Miami");
        owner.setTelephone("100");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Sam");
        owner.getPets().add(mikesPet);
        ownerService.save(owner);

        System.out.println("Owners loading....");
        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Colby");
        owner1.setLastName("Covington");
        owner1.setAddress("123 Ocean");
        owner1.setCity("Miami");
        owner1.setTelephone("100");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(3L);
        owner2.setFirstName("Robert");
        owner2.setLastName("Whittaker");
        owner2.setAddress("123 Ocean");
        owner2.setCity("Miami");
        owner2.setTelephone("100");
        ownerService.save(owner2);

        System.out.println("Owners was created");

        Vet vet = new Vet();
        vet.setId(1l);
        vet.setFirstName("Holloway");
        vet.setLastName("Max");

        Vet vet2 = new Vet();
        vet2.setId(2l);
        vet2.setFirstName("Sam");
        vet2.setLastName("rrr");

        Vet vet3 = new Vet();
        vet3.setId(3l);
        vet3.setFirstName("aaa");
        vet3.setLastName("bbbb");

        Vet vet4 = new Vet();
        vet4.setId(3l);
        vet4.setFirstName("aaa");
        vet4.setLastName("bbbb");

        vetService.save(vet);
        vetService.save(vet2);
        vetService.save(vet3);
        vetService.save(vet4);

//        System.out.println(ownerService.findById(1L));
    }
}

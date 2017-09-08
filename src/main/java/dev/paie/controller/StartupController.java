package dev.paie.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import dev.paie.service.InitialiserDonneesService;
import dev.paie.service.InitialiserDonneesServiceDev;

/**
 * Controller exécuté une fois que le contexte spring est entièrement chargé :
 * event {@link ContextRefreshedEvent}
 * 
 * @author DIGINAMIC
 */
@Controller
public class StartupController {
	@Autowired
	private InitialiserDonneesServiceDev initService;
//	private static final Logger LOGGER = LoggerFactory.getLogger(StartupController.class);

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		// code exécuté une fois que le contexte Spring est entièrement chargé
//		LOGGER.info("Initialisation des données");
		initService.initialiser();
	}
}

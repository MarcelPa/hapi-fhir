package ca.uhn.fhir.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class VersionEnumTest {

	@Test
	public void testCurrentVersionExists() {
		List<String> versions = Arrays.stream(VersionEnum.values())
			.map(Enum::name)
			.collect(Collectors.toList());

		String version = VersionUtil.getVersion();
		version = "V" + version.replace(".", "_");
		version = version.replaceAll("-[a-zA-Z0-9]+$", "");

		assertThat(versions, hasItem(version));
	}


}

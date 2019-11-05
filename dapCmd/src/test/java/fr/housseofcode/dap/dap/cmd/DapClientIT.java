package fr.housseofcode.dap.dap.cmd;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author house.
 *
 */
public class DapClientIT {

    /**
     * Verify that the URLs to the Dap server are working well.
     */
    @Test
    public void testGetDapData() {
        @SuppressWarnings("PMD.AvoidFinalLocalVariable")
        final String path = "/emails/unread/count";
        @SuppressWarnings("PMD.AvoidFinalLocalVariable")
        final String userId = "virginie";
        final String res = DapClient.getDapData(path, userId);

        Assert.assertEquals("valeur invalide", "1123", res);

    }
}
